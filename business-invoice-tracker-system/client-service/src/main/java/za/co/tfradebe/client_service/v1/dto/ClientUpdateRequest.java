package za.co.tfradebe.client_service.v1.dto;

import jakarta.persistence.Embedded;
import lombok.Data;
import za.co.tfradebe.client_service.model.Address;

@Data
public class ClientUpdateRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
}
