import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CreateProfileRequest, CreateProfileResponse, LoginRequest, LoginResponse} from '../model/models';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService{
  private baseUrl = "http://localhost:8082/users";

  constructor(private http: HttpClient){}

  createProfile(profileData: CreateProfileRequest): Observable<CreateProfileResponse> {
    return this.http.post<CreateProfileResponse>(`${this.baseUrl}/profile`, profileData);
  }

  getProfile(userId: number): Observable<CreateProfileResponse> {
    return this.http.get<CreateProfileResponse>(`${this.baseUrl}/profile/${userId}`);
  }

  login(loginData: LoginRequest): Observable<LoginResponse>{
    return this.http.post<LoginResponse>(`${this.baseUrl}/login`, loginData);
  }

}
