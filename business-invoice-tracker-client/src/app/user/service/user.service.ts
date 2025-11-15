import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CreateProfileRequest, CreateProfileResponse, LoginRequest, LoginResponse, UserResponse} from '../model/models';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService{
  private baseUrl = "http://localhost:8082/users";

  constructor(private http: HttpClient){}

  createProfile(profileData: CreateProfileRequest): Observable<UserResponse> {
    return this.http.post<UserResponse>(`${this.baseUrl}/profile`, profileData);
  }

  getProfile(userId: number): Observable<UserResponse> {
    return this.http.get<UserResponse>(`${this.baseUrl}/profile/${userId}`);
  }

  login(loginData: LoginRequest): Observable<UserResponse>{
    return this.http.post<UserResponse>(`${this.baseUrl}/login`, loginData);
  }

}
