import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserRegistration } from '../model/model';
import { AuthenticationUrls, ClientServiceUrls } from '../utils/urls.constant';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) {}
  public login(loginRequest:any){
    return this.http.post(AuthenticationUrls.LOGIN,loginRequest);
  }
  
  public isLoggedIn(token:any):Promise<any>{
    let params = new HttpParams();
    params = params.append("token",token);
    return this.http.get(AuthenticationUrls.CHECK_IS_LOGGEDIN,{params:params}).toPromise();
  }

  public register(userModel:UserRegistration): Observable<any>{
    return this.http.post(AuthenticationUrls.REGISTER_USER, userModel);
  }

  getCustomerByUserName(username: string): Observable<any> {
    let params = new HttpParams();
    params = params.append('username',username);
    return this.http.get<any>(ClientServiceUrls.GET_CUSTOMER_BY_USER_NAME,{params:params});
  }
}
