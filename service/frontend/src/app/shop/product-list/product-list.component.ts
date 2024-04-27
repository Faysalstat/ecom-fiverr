import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartItem, Product } from 'src/app/model/model';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  constructor(
    private productService:ProductService,
    private router:Router,
    private cartService:CartService
  ) { }

  ngOnInit(): void {
    this.productService.getAllProduct().subscribe({
      next:(res)=>{
        this.products = res;
      }
    });
  }

  addToCart(productId:any){
    let cartModel = new CartItem();
    cartModel.productId = productId;
    cartModel.userId = Number(localStorage.getItem("userId") || "")
    this.cartService.addToCart(cartModel).subscribe({
      next:(res)=>{
        alert("Added to cart list")
      }
    })

  }

  showDetails(productId:any){
    this.router.navigate(['shop/product-details',productId]);
  }

}
