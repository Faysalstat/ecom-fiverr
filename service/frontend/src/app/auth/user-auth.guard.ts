import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { AuthService } from "./auth.service";

@Injectable({
    providedIn: 'root',
  })
  export class UserAuthGuard implements CanActivate {
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
      console.log(authenticated);
      if (!authenticated) {
        this.router.navigate(['auth']);
      }
      let userRole = localStorage.getItem('userRole');
      if (userRole == 'CUSTOMER') {
        //console.log('Welcome to admin panel');
      } else if (userRole == 'ADMIN') {
        //console.log('Welcome to manager panel');
        alert("ADMIN is not permitted");
        this.router.navigate(['auth']);
      } else {
        //console.log('You are not permited to admin panel');
        this.router.navigate(['auth']);
      }
      return authenticated;
    }
  }