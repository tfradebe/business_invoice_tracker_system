package za.co.tfradebe.notification_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import za.co.tfradebe.notification_service.v1.controller.NotificationController;
import za.co.tfradebe.notification_service.v1.dto.*;

import java.util.List;

import static za.co.tfradebe.notification_service.util.NotificationResponseUtil.createErrorDetails;
import static za.co.tfradebe.notification_service.util.NotificationResponseUtil.createFailResponse;

@ControllerAdvice(assignableTypes = NotificationController.class)
public class NotificationExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotificationResponse> notFoundException(NotFoundException ex) {
        var code = HttpStatus.NOT_FOUND.toString();
        return new ResponseEntity<>(createFailResponse(code, List.of(createErrorDetails(code, ex.getMessage()))), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<NotificationResponse> handleException(Exception e) {
        var code = "GENERAL_ERROR";
        return new ResponseEntity<>(createFailResponse(code, List.of(createErrorDetails(code, e.getMessage()))),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
