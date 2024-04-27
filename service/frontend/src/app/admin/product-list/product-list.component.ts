import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/model';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  constructor(
    private productService:ProductService
  ) { }

  ngOnInit(): void {
    this.productService.getAllProduct().subscribe({
      next:(res)=>{
        this.products = res;
      }
    });
  }

}
