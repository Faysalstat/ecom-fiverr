import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { Product } from '../../model/model';

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
