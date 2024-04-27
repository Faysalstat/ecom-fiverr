import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderDetails } from 'src/app/model/model';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.scss']
})
export class OrderListComponent implements OnInit {
  orders:OrderDetails[] = [];
  userId:any;
  constructor(
    private orderService:OrderService,
   
  ) { }

  ngOnInit(): void {
    this.userId = localStorage.getItem("userId");
    this.getAllOrdersByUser();
  }
  getAllOrdersByUser(){
    this.orderService.getAllOrderByUserId(this.userId).subscribe({
      next:(res)=>{
        this.orders=res;
        
      },
      error:(err)=>{
        console.log(err);
      }
    })
  }
}
