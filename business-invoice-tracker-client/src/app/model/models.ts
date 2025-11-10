export interface CreateProfileRequest{
  name: string;
  email: string;
  userpassword: string;
}

export interface CreateProfileResponse{
  id: number;
  name: string;
  email: string;
}

export interface LoginRequest{
  email: string;
  userpassword: string;
}

export interface LoginResponse{
  success: boolean;
}
