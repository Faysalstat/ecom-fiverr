import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderDetails, OrderItem } from 'src/app/model/model';
import { CartService } from 'src/app/services/cart.service';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  styleUrls: ['./cart-list.component.scss']
})
export class CartListComponent implements OnInit {
  orderItems!:OrderItem[];
  totalOrderCost = 0;
  userId:any;
  constructor(
    private orderService:OrderService,
    private router:Router
  ) {
    this.orderItems = [];
  }

  ngOnInit(): void {
    this.userId = localStorage.getItem("userId");
    this.getCartList(this.userId);
  }

  getCartList(userId:any){
    this.orderService.getAllCartByCustomerID(userId).subscribe({
      next:(res)=>{
        let products = res;
        products.map((prod:any)=>{
          let order:OrderItem = new OrderItem;
          order.productDTO = prod;
          order.price = prod.price;
          this.orderItems.push(order)
        })
      }
    })

  }
  calculateTotal(i:any){
    this.totalOrderCost += this.orderItems[i].price * this.orderItems[i].quantity;
    this.orderItems[i].totalPrice = this.orderItems[i].price * this.orderItems[i].quantity;
  }
  checkout(){
    let orderItemList:OrderItem[] = [];
    this.orderItems.map((item)=>{
      if(item.quantity>0){
        orderItemList.push(item);
      }
    })
    let orderModel = new OrderDetails();
    orderModel.orderItemDTOS = orderItemList;
    orderModel.orderStatus = "PENDING";
    orderModel.totalCost = this.totalOrderCost;
    orderModel.userId = this.userId;
    this.orderService.createOrder(orderModel).subscribe({
      next:(res)=>{
        console.log(res);
        this.router.navigate(['shop/order-list'])
      },
      error:(err)=>{
        console.log(err);
      }
    }) 
  }
}
