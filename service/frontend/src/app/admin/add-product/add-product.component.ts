import { Component, OnInit } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup, Validators } from '@angular/forms';
import { ProductService } from '../../services/product.service';
import { Product } from '../../model/model';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.scss'],
})
export class AddProductComponent implements OnInit {
  productCreateForm!: UntypedFormGroup;
  categories: any[] = [];
  selectedFile!: File;
  imagePath:string = "default.jpg"
  constructor(
    private productService: ProductService,
    private formBuilder:UntypedFormBuilder
  ) {
    this.prepareForm();
    this.categories = [
      { label: 'Book', value: 'Book' },
      { label: 'Card', value: 'Card' },
      { label: 'Jewellary', value: 'Jewellary' },
      { label: 'Cloth', value: 'Cloth' },
      { label: 'Technology', value: 'Technology' },
    ];
  }

  ngOnInit(): void {}
  prepareForm() {
    let formData = new Product();
    this.productCreateForm = this.formBuilder.group({
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

  onFileChanged(event: any) {
    this.selectedFile = event.target.files[0];
    this.uploadImage();
  }
  uploadImage() {
    this.productService.uploadImage(this.selectedFile).subscribe({
      next: (res) => {
        this.imagePath = res.body;
        this.productCreateForm.get("image")?.setValue(res.body);
      },
    });
  }
  addProduct() {
    if(this.productCreateForm.invalid){
      alert("Form Invalid");
      return;
    }
    let productModel = this.productCreateForm.value;
    this.productService
      .createProduct(productModel)
      .subscribe({
        next: (res) => {
          this.prepareForm();
          this.imagePath = "default.jpg"
        },
      });
  }
}
