import { Injectable } from '@angular/core';
import { Cart, CartItem, OrderDetails } from '../model/model';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { OrderServiceUrls } from '../utils/urls.constant';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) {}
  
  public createOrder(orderModel: OrderDetails): Observable<any> {
    return this.http.post(OrderServiceUrls.CREATE_ORDER, orderModel);
  }

  public updateOrder(orderModel: OrderDetails): Observable<any> {
    return this.http.post(OrderServiceUrls.UPDATE_ORDER, orderModel);
  }
  public getAllOrder(): Observable<any> {
    return this.http.get(OrderServiceUrls.GET_ALL_ORDER);
  }

  public getAllOrderByUserId(userId: number): Observable<any> {
    let params = new HttpParams();
    params = params.append('userId', userId);
    return this.http.get(OrderServiceUrls.GET_ALL_ORDER_BY_CUSTOMER, {
      params: params,
    });
  }

  public getAllOrderByStatus(status: string): Observable<any> {
    let params = new HttpParams();
    params = params.append('status', status);
    return this.http.get(OrderServiceUrls.GET_ALL_ORDER_BY_STATUS, {
      params: params,
    });
  }


  public addToCart(cartItem: CartItem): Observable<any> {
    return this.http.post(OrderServiceUrls.CREATE_CART, cartItem);
  }

  public getAllCartByCustomerID(userId: number): Observable<any> {
    let params = new HttpParams();
    params = params.append('userId', userId);
    return this.http.get(OrderServiceUrls.GET_ALL_CART_BY_CUSTOMER, {
      params: params,
    });
  }
}
