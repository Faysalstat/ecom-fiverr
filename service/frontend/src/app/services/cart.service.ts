import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CartItem } from '../model/model';
import { Observable } from 'rxjs';
import { CartServiceUrls } from '../utils/urls.constant';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http: HttpClient) {}
  
  public addToCart(cartItem: CartItem): Observable<any> {
    return this.http.post(CartServiceUrls.ADD_TO_CART,cartItem);
  }

  public getAllCartList(): Observable<any> {
    let params = new HttpParams();
    params = params.append('userId', localStorage.getItem('userId') || '');
    return this.http.get(CartServiceUrls.GET_CART_LIST);
  }
}
