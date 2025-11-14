package za.co.tfradebe.user_service.v1.util;

import za.co.tfradebe.user_service.v1.dto.UserResponse;
import za.co.tfradebe.user_service.v1.dto.model.UserDto;
import za.co.tfradebe.user_service.v1.error.ErrorDetail;

import java.util.List;

public class UserResponseUtil {

    private UserResponseUtil(){}

    public static UserResponse createSuccessResponse(List<UserDto> users){
        var response = new UserResponse();
        response.setData(users);
        response.setStatus("SUCCESS");
        return response;
    }

    public static UserResponse createFailResponse(String code, String message, List<ErrorDetail> errors) {
        var response = new UserResponse();
        response.setStatus("ERROR");
        response.setCode(code);
        response.setError(errors);
        return response;
    }


    public static ErrorDetail createErrorDetails(String code, String message){
        var error = new ErrorDetail();
        error.setCode(code);
        error.setMessage(message);
        return error;
    }
}
