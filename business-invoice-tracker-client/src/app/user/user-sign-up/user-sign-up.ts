import {Component} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CreateProfileRequest, CreateProfileResponse} from '../model/models';
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
    username: '',
    email: '',
    userpassword: ''
  };

  password2 = '';

  createdProfile: CreateProfileResponse | null = null;
  errorMessage: string = '';
  passwordMessage: string = '';

  constructor(private userService: UserService) {
  }

  onCreateProfile(): void {
    if(this.checkPassword()) {
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
    } else {
      this.passwordMessage = 'Enter same password';
    }
  }

  checkPassword(): boolean {
    return this.password2 == this.profileData.userpassword;
  }

  resetForms(): void {
    this.profileData = {username: '', email: '', userpassword: ''};
    this.createdProfile = null;
    this.errorMessage = '';
  }

}
