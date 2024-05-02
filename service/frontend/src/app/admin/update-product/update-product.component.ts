import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from '../../services/product.service';
import { Product } from '../../model/model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrl: './update-product.component.css'
})
export class UpdateProductComponent {
  productId!:number;
  product!:Product;
  productUpdateForm!:FormGroup;
  constructor(
    private activatedRoute:ActivatedRoute,
    private productService:ProductService,
    private formBuilder:FormBuilder
  ) {
    this.prepareForm();
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe({
      next:(params) => {
        this.productId = params['id'];
        this.getProductDetails();
      }
    })

  }
  prepareForm() {
    let formData = new Product();
    this.productUpdateForm = this.formBuilder.group({
      id:[formData.id],
      code:[formData.code,Validators.required],
      name:[formData.name,Validators.required],
      description:[formData.description,Validators.required],
      price:[formData.price,Validators.required],
      quantity: [formData.quantity, [Validators.required]],
      category: [formData.category, [Validators.required]],
      image: [formData.image, [Validators.required]],
    });
  }
  getProductDetails(){
    this.productService.getProductById(this.productId).subscribe({
      next:(res)=>{
        this.product = res;
        this.productUpdateForm.get("id")?.setValue(this.product.id);
        this.productUpdateForm.get("code")?.setValue(this.product.code);
        this.productUpdateForm.get("name")?.setValue(this.product.name);
        this.productUpdateForm.get("description")?.setValue(this.product.description);
        this.productUpdateForm.get("price")?.setValue(this.product.price);
        this.productUpdateForm.get("quantity")?.setValue(this.product.quantity);
        this.productUpdateForm.get("category")?.setValue(this.product.category);
        this.productUpdateForm.get("image")?.setValue(this.product.image);
      }
    })
  }

  UpdateProduct(){
    let updateModel = this.productUpdateForm.value;
    this.productService.updateProduct(updateModel).subscribe({
      next:(res)=>{
        console.log(res);
        alert("Successfully Updated")
        this.getProductDetails();
      },
      error:(err)=>{
        console.log(err)
      }
    })
  }
}
