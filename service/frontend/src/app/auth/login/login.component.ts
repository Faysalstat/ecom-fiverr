import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private authService:AuthService,
    private router:Router
  ) { }

  ngOnInit(): void {
  }

  submitForm(data:any){
    this.authService.login(data).subscribe({
      next: (response: any) => {
        console.log(response);
        let role = response.userRole;
        localStorage.setItem('token',response.token);
        localStorage.setItem("username", response.userName);
        localStorage.setItem("userRole", response.userRole);
        localStorage.setItem("userId", response.userId);
        if (role === 'ADMIN') {
          this.router.navigate(['admin']);
        }
        if (role === 'CUSTOMER') {
          this.router.navigate(['shop']);
        }
      },
      error: (error) => {
        console.log(error);
        alert('Wrong Credentials Entered');
      }
    });
  }

}
