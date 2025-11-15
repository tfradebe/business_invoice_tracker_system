package za.co.tfradebe.user_service.v1.dto.model;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String userPassword;
    private String email;
}
