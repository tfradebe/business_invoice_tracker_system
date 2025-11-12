package za.co.tfradebe.client_service.v1.dto;

import za.co.tfradebe.client_service.v1.dto.model.ClientDto;

import java.util.List;

public class ClientResponseUtil {

    private ClientResponseUtil(){}

    public static ClientCreateResponse createSuccessResponse(List<ClientDto> clients){
        var response = new ClientCreateResponse();
        response.setData(clients);
        response.setStatus("SUCCESS");
        return response;
    }
}
