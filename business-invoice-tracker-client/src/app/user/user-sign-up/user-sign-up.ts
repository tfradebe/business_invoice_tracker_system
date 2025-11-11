import {Component} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CreateProfileRequest, CreateProfileResponse} from '../../model/models';
import {UserService} from '../service/user.service';

@Component({
  selector: 'app-user-sign-up',
  imports: [
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './user-sign-up.html',
  styleUrl: './user-sign-up.css',
})
export class UserSignUp {
  title = "Sign up";

  profileData: CreateProfileRequest = {
    name: '',
    email: '',
    userpassword: ''
  };

  createdProfile: CreateProfileResponse | null = null;
  errorMessage: string = '';

  constructor(private userService: UserService) {
  }

  onCreateProfile(): void {
    this.errorMessage = '';
    this.userService.createProfile(this.profileData).subscribe({
      next: (response) => {
        this.createdProfile = response;
        console.log('Profile created: ', response);
      },
      error: (error) => {
        this.errorMessage = 'Error creating profile: ' + error.message;
        console.error('Error creating profile: ', error);
      }
    });
  }

  resetForms(): void {
    this.profileData = {name: '', email: '', userpassword: ''};
    this.createdProfile = null;
    this.errorMessage = '';
  }

}
