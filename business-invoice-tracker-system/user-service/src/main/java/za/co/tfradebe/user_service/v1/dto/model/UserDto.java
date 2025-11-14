package za.co.tfradebe.user_service.v1.dto.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String userpassword;
    private String email;
}
