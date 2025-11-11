import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {UserComponent} from './user-component/user-component';
import {UserSignUp} from './user/user-sign-up/user-sign-up';
import {UserLogin} from './user/user-login/user-login';
import {UserSearch} from './user/user-search/user-search';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, UserComponent, UserSignUp, UserLogin, UserSearch],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('business-invoice-tracker-client');
}
