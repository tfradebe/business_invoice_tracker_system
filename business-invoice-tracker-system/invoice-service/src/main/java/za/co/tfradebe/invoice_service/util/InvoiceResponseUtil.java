package za.co.tfradebe.invoice_service.util;

import za.co.tfradebe.invoice_service.v1.dto.InvoiceResponse;
import za.co.tfradebe.invoice_service.v1.dto.error.ErrorDetail;
import za.co.tfradebe.invoice_service.v1.dto.model.InvoiceDto;

import java.util.List;

public class InvoiceResponseUtil {

    private InvoiceResponseUtil(){}

    public static InvoiceResponse createSuccessResponse(List<InvoiceDto> users){
        var response = new InvoiceResponse();
        response.setData(users);
        response.setStatus("SUCCESS");
        return response;
    }

    public static InvoiceResponse createFailResponse(String code, String message, List<ErrorDetail> errors) {
        var response = new InvoiceResponse();
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
