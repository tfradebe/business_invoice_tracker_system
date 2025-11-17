import { Component } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {UserService} from '../service/user.service';
import { UserResponse} from '../model/models';

@Component({
  selector: 'app-user-search',
  imports: [
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './user-search.html',
  styleUrl: './user-search.css',
})
export class UserSearch {
  title = "User User Profile";

  errorMessage: string = '';
  userEmailToFetch: string | null = null;
  fetchedProfile: UserResponse | null = null;

  constructor(private userService: UserService){}

  onGetProfile(): void {
    if(this.userEmailToFetch !== null){
      this.errorMessage = '';
      this.userService.getProfile(this.userEmailToFetch).subscribe({
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


}
