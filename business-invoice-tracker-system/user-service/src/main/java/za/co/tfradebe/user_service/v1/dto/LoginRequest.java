package za.co.tfradebe.user_service.v1.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private char[] userPassword;
}
