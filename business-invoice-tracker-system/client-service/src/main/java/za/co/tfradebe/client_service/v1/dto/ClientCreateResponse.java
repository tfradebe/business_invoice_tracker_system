package za.co.tfradebe.client_service.v1.dto;

import lombok.Data;
import za.co.tfradebe.client_service.v1.dto.model.ClientDto;
import za.co.tfradebe.client_service.v1.error.ErrorDetail;

import java.util.List;

@Data
public class ClientCreateResponse {
    private String status;
    private String code;
    private List<ErrorDetail> error;
    private List<ClientDto> data;
}
