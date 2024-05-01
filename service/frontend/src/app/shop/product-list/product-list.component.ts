import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from '../../services/product.service';
import { CartItem, Product } from '../../model/model';
import { CartService } from '../../services/cart.service';

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
        let products = res;
        this.products = [];
        products.map((elem:any)=>{
          let product:Product =new Product();
          product = {...elem};
          product.image = "../../../assets/img/product/" + elem.image;
          this.products.push(product);
        })
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
