package za.co.tfradebe.user_service.v1.dto;

import lombok.Data;

@Data
public class CreateProfileRequest {
    private String username;
    private char[] userpassword;
    private String email;
}
