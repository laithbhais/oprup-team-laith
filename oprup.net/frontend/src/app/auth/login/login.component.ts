import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  public show: boolean = false;
  public loginForm: FormGroup | any;
  public errorMessage: any;

  constructor(  private fb: FormBuilder,private router:Router) {
      this.loginForm = this.fb.group({
        email: ['spruko@template.com', [Validators.required, Validators.email]],
        password: ['spruko', Validators.required]
      });
      
  }

  ngOnInit() {
  }

  showPassword() {
    this.show = !this.show;
  }
  


  login(){
    if (this.loginForm.controls['email'].value === "spruko@template.com" && this.loginForm.controls['password'].value === "spruko")
    {
      this.router.navigate(['/dashboard/dashboard01']);
    }
  }
}
