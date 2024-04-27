import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../model/model';
import { Observable } from 'rxjs';
import { ProductServiceUrls } from '../utils/urls.constant';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  constructor(private http: HttpClient) {}
  public uploadImage(file:File): Observable<any> {
    const formData = new FormData();
    formData.append('image', file);
    return this.http.post(ProductServiceUrls.UPLOAD, formData);
  }
  public createProduct(productModel: Product): Observable<any> {
    return this.http.post(ProductServiceUrls.CREATE_PRODUCT, productModel);
  }
  public getAllProduct(): Observable<any> {
    return this.http.get(ProductServiceUrls.GET_ALL_PRODUCT);
  }

  public getProductById(id: number): Observable<any> {
    let params = new HttpParams();
    params = params.append('id', id);
    return this.http.get(ProductServiceUrls.GET_PRODUCT_BY_ID, {
      params: params,
    });
  }
}
