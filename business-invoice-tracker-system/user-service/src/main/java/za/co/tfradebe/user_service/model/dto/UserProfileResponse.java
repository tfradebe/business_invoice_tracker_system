package za.co.tfradebe.user_service.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserProfileResponse {
    private Long id;
    private String companyName;
    private String address;
    private String phone;
    private String logoUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
