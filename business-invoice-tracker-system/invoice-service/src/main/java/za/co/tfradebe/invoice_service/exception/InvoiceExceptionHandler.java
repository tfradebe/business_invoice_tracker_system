package za.co.tfradebe.invoice_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import za.co.tfradebe.invoice_service.v1.controller.InvoiceController;
import za.co.tfradebe.invoice_service.v1.dto.InvoiceResponse;

import java.util.List;

import static za.co.tfradebe.invoice_service.util.InvoiceResponseUtil.createErrorDetails;
import static za.co.tfradebe.invoice_service.util.InvoiceResponseUtil.createFailResponse;


@ControllerAdvice(assignableTypes = {InvoiceController.class})
public class InvoiceExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<InvoiceResponse> notFoundException(NotFoundException ex) {
        var code = HttpStatus.NOT_FOUND.toString();
        return new ResponseEntity<>(createFailResponse(code,ex.getMessage(), List.of(createErrorDetails(code, ex.getMessage()))), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<InvoiceResponse> handleException(Exception e) {
        var code = "GENERAL_ERROR";
        return new ResponseEntity<>(createFailResponse(code, "Something went wrong", List.of(createErrorDetails(code, e.getMessage()))),HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
