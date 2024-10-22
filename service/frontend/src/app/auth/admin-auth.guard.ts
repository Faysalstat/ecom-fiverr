import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { AuthService } from "./auth.service";

@Injectable({
    providedIn: 'root',
  })
  export class AdminAuthGuard  {
    constructor(
      private router: Router,
      private authService :AuthService,
    ){}
    canActivate(
      route: ActivatedRouteSnapshot,
      state: RouterStateSnapshot
    ):
      | Observable<boolean | UrlTree>
      | Promise<boolean | UrlTree>
      | boolean
      | UrlTree {
      const idToken = localStorage.getItem('token');
      return this.verifyAdmin(idToken);
    }
    async verifyAdmin(token: any) {
      if (!token) {
        this.router.navigate(['auth']);
      }
      let authenticated = await this.authService.isLoggedIn(token);
      if (!authenticated) {
        this.router.navigate(['auth']);
      }
      let userRole = localStorage.getItem('userRole');
      if (userRole == 'ADMIN') {
        //console.log('Welcome to admin panel');
      } else if (userRole == 'CUSTOMER') {
        //console.log('Welcome to manager panel');
        alert("Customer is not permitted");
        this.router.navigate(['auth']);
      } else {
        //console.log('You are not permited to admin panel');
        this.router.navigate(['auth']);
      }
      return authenticated;
    }
  }