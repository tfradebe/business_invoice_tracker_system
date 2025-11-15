import { Component } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {LoginRequest, UserResponse} from '../model/models';
import {UserService} from '../service/user.service';

@Component({
  selector: 'app-user-login',
  imports: [
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './user-login.html',
  styleUrl: './user-login.css',
})
export class UserLogin {
  title = "User Login";

  errorMessage: string = '';

  loginData: LoginRequest = {
    email: '',
    userpassword: ''
  };

  loginResult: UserResponse | null = null;

  constructor(private userService: UserService){}


  onLogin(): void {
    this.errorMessage = '';
    this.userService.login(this.loginData).subscribe({
      next: (response) => {
        this.loginResult = response;
        console.error('Login result: ', response);
      },
      error: (error) => {
        this.errorMessage = 'Login failed: '+ error.message;
        console.error('Login error: ', error);
      }
    });
  }
}
