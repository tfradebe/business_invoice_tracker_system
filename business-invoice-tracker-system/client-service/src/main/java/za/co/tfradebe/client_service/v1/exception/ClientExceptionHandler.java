package za.co.tfradebe.client_service.v1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import za.co.tfradebe.client_service.v1.controller.ClientController;
import za.co.tfradebe.client_service.v1.dto.ClientResponse;
import java.util.List;

import static za.co.tfradebe.client_service.v1.dto.ClientResponseUtil.createErrorDetails;
import static za.co.tfradebe.client_service.v1.dto.ClientResponseUtil.createFailResponse;

@ControllerAdvice(assignableTypes = {ClientController.class})
public class ClientExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ClientResponse> notFoundException(NotFoundException ex) {
        var code = HttpStatus.NOT_FOUND.toString();
        return new ResponseEntity<>(createFailResponse(code,ex.getMessage(), List.of(createErrorDetails(code, ex.getMessage()))), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ClientResponse> handleException(Exception e) {
        var code = "GENERAL_ERROR";
        return new ResponseEntity<>(createFailResponse(code, "Something went wrong", List.of(createErrorDetails(code, e.getMessage()))),HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
