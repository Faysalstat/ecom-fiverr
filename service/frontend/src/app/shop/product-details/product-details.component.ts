import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CartItem, Product } from 'src/app/model/model';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.scss']
})
export class ProductDetailsComponent implements OnInit {
  productId!:number;
  product!:Product;
  constructor(
    private activatedRoute:ActivatedRoute,
    private productService:ProductService,
    private cartService:CartService
  ) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe({
      next:(params) => {
        this.productId = params['productId'];
        this.getProductDetails();
      }
    })

  }

  getProductDetails(){
    this.productService.getProductById(this.productId).subscribe({
      next:(res)=>{
        console.log(res);
        this.product = res;
      }
    })
  }
  addToCart(productId:any){
    let cartModel = new CartItem();
    cartModel.productId = productId;
    cartModel.userId = Number(localStorage.getItem("userId")||"1");
    this.cartService.addToCart(cartModel).subscribe({
      next:(res)=>{
        alert("Added to cart list")
      }
    })

  }
}
