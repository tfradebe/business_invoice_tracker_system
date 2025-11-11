export interface CreateProfileRequest{
  username: string;
  email: string;
  userpassword: string;
}

export interface CreateProfileResponse{
  id: number;
  username: string;
  email: string;
}

export interface LoginRequest{
  email: string;
  userpassword: string;
}

export interface LoginResponse{
  success: boolean;
}
