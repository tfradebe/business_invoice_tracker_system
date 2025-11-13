package za.co.tfradebe.client_service.v1.dto;

import za.co.tfradebe.client_service.v1.dto.model.ClientDto;
import za.co.tfradebe.client_service.v1.error.ErrorDetail;

import java.util.List;

public class ClientResponseUtil {

    private ClientResponseUtil(){}

    public static ClientResponse createSuccessResponse(List<ClientDto> clients){
        var response = new ClientResponse();
        response.setData(clients);
        response.setStatus("SUCCESS");
        return response;
    }

    public static ClientResponse createFailResponse(String code, String message, List<ErrorDetail> errors) {
        var response = new ClientResponse();
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
