package za.co.tfradebe.user_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import za.co.tfradebe.user_service.v1.controller.UserController;
import za.co.tfradebe.user_service.v1.dto.UserResponse;

import java.util.List;

import static za.co.tfradebe.user_service.v1.util.UserResponseUtil.createErrorDetails;
import static za.co.tfradebe.user_service.v1.util.UserResponseUtil.createFailResponse;


@ControllerAdvice(assignableTypes = {UserController.class})
public class UserExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<UserResponse> notFoundException(NotFoundException ex) {
        var code = HttpStatus.NOT_FOUND.toString();
        return new ResponseEntity<>(createFailResponse(code,ex.getMessage(), List.of(createErrorDetails(code, ex.getMessage()))), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<UserResponse> handleException(Exception e) {
        var code = "GENERAL_ERROR";
        return new ResponseEntity<>(createFailResponse(code, "Something went wrong", List.of(createErrorDetails(code, e.getMessage()))),HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
