package za.co.tfradebe.client_service.v1.dto;

import lombok.Data;
import za.co.tfradebe.client_service.model.Address;

@Data
public class ClientCreateRequest {
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
}
