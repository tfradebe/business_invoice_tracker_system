package za.co.tfradebe.client_service.v1.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import za.co.tfradebe.client_service.model.Address;

@Data
public class ClientCreateRequest {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Email
    private String email;
    @Valid
    private Address address;
}
