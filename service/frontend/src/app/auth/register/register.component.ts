import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { UntypedFormBuilder, UntypedFormGroup, Validators } from '@angular/forms';
import { UserRegistration } from '../../model/model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registrationForm!: UntypedFormGroup;
  constructor(
    private authService:AuthService,
    private router:Router,
    private formBuilder:UntypedFormBuilder
  ) {
    this.prepareForm()
  }

  ngOnInit(): void {
  }
  prepareForm() {
    let formData = new UserRegistration();
    this.registrationForm = this.formBuilder.group({
      firstName:[formData.firstName,[Validators.required]],
      lastName:[formData.lastName,Validators.required],
      phoneNumber:[formData.phoneNumber,Validators.required],
      address:[formData.address,Validators.required],
      userRole:[formData.userRole,Validators.required],
      email: [formData.email, [Validators.required]],
      password: [formData.password, [Validators.required]],
    });
  }
  onSubmit(){
    if(this.registrationForm.invalid){
      alert("form Invalid");
      return;
    }
    let registrationModel = this.registrationForm.value;
    console.log(registrationModel);
    this.authService.register(registrationModel).subscribe({
      next:(res)=>{
        console.log(res);
        this.router.navigate(['auth']);
      }
    })
  }
}
