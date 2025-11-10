import { Component } from '@angular/core';
import {CreateProfileRequest, CreateProfileResponse, LoginRequest, LoginResponse} from '../model/models';
import {UserService} from '../service/user.service';

@Component({
  selector: 'app-user-component',
  imports: [],
  templateUrl: './user-component.html',
  styleUrl: './user-component.css',
})
export class UserComponent {
  title = "User Component";

  profileData: CreateProfileRequest = {
    name: '',
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




}
