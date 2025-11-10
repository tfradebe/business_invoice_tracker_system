package za.co.tfradebe.user_service.v1.dto;

import lombok.Data;

@Data
public class UpdateProfileRequest {
    private Long id;
    private String username;
    private String userpassword;
    private String email;
}
