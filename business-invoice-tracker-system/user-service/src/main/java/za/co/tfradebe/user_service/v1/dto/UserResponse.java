package za.co.tfradebe.user_service.v1.dto;


import lombok.Data;
import za.co.tfradebe.user_service.v1.dto.model.UserDto;
import za.co.tfradebe.user_service.v1.error.ErrorDetail;

import java.util.List;

@Data
public class UserResponse {
    private String status;
    private String code;
    private Boolean login;
    private List<ErrorDetail> error;
    private List<UserDto> data;
}
