import { Component, OnInit } from '@angular/core';
import { OrderDetails } from '../../model/model';
import { OrderService } from '../../services/order.service';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.scss']
})
export class OrderListComponent implements OnInit {
  orders:OrderDetails[] = [];
  constructor(
    private orderService:OrderService
  ) { }

  ngOnInit(): void {
    this.getAllOrdersByStatus();
  }
  getAllOrdersByStatus(){
    this.orderService.getAllOrderByStatus("PENDING").subscribe({
      next:(res)=>{
        console.log(res);
        this.orders=res;
        
      },
      error:(err)=>{
        console.log(err);
      }
    })
  }

  confirmOrder(order:any){
    order.orderStatus = "PROCESSING";
    this.orderService.updateOrder(order).subscribe({
      next:(res)=>{
        console.log(res);
        this.getAllOrdersByStatus();
      }
    })
  }
}
