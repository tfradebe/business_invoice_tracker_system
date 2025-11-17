export interface CreateProfileRequest{
  username: string;
  email: string;
  userPassword: string;
}

export interface LoginRequest{
  email: string;
  userPassword: string;
}

export interface ErrorDetails{
  code: string;
  message: string;
  details: {[key: string]: string};
}

export interface UserDto {
  id: number;
  username: string;
  userPassword: string;
  email: string;
}

export interface UserResponse {
  status: string;
  code: string;
  login: boolean;
  error: ErrorDetails[];
  data: UserDto[];
}
