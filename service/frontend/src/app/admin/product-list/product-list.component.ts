import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { Product } from '../../model/model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  constructor(
    private productService:ProductService,
    private router:Router
  ) { }

  ngOnInit(): void {
    this.getAllProducts();
  }

  getAllProducts(){
    this.productService.getAllProduct().subscribe({
      next:(res)=>{
        this.products = res;
      }
    });
  }

  delete(product:any){
    this.productService.deleteProduct(product).subscribe({
      next:(res)=>{
        console.log(res);
        this.getAllProducts();
      }
    })
  }

  edit(id:any){
    this.router.navigate(['/admin/update-product',id]);
  }

}
