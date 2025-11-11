import { Component } from '@angular/core';
import {CreateProfileRequest, CreateProfileResponse, LoginRequest, LoginResponse} from '../user/model/models';
import {UserService} from '../user/service/user.service';
import {NgIf} from '@angular/common';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-user-component',
  imports: [
    FormsModule
  ],
  templateUrl: './user-component.html',
  styleUrl: './user-component.css',
})
export class UserComponent {
  title = "User Component";

  profileData: CreateProfileRequest = {
    username: '',
    email: '',
    userpassword: ''
  };

  loginData: LoginRequest = {
    email: '',
    userpassword: ''
  };

  userIdToFetch: number | null = null;
  createdProfile: CreateProfileResponse | null = null;
  fetchedProfile: CreateProfileResponse | null = null;
  loginResult: LoginResponse | null = null;
  errorMessage: string = '';

  constructor(private userService: UserService){}

  onCreateProfile(): void {
    this.errorMessage = '';
    this.userService.createProfile(this.profileData).subscribe({next: (response) => {
      this.createdProfile = response;
      console.log('Profile created: ', response);
      },
      error: (error) =>{
      this.errorMessage = 'Error creating profile: '+error.message;
      console.error('Error creating profile: ', error);
      }
    });
  }

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

  onGetProfile(): void {
    if(this.userIdToFetch !== null){
      this.errorMessage = '';
      this.userService.getProfile(this.userIdToFetch).subscribe({
        next: (response) => {
          this.fetchedProfile = response;
          console.log('Profile fetched: ', response);
        },
        error: (error) => {
          this.errorMessage = 'Error fetching profile: '+ error.message;
          console.error('Error fetching profile: ', error);
        }
      });
    }
  }

  resetForms(): void {
    this.profileData = {username: '', email: '', userpassword: ''};
    this.loginData = {email: '', userpassword: ''};
    this.userIdToFetch = null;
    this.createdProfile = null;
    this.fetchedProfile = null;
    this.loginResult = null;
    this.errorMessage = '';
  }

}
