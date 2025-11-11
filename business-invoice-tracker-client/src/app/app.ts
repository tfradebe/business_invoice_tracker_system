import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {UserComponent} from './user-component/user-component';
import {UserSignUp} from './user/user-sign-up/user-sign-up';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, UserComponent, UserSignUp],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('business-invoice-tracker-client');
}
