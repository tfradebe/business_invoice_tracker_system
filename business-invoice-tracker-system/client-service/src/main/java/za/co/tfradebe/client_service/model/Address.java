package za.co.tfradebe.client_service.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Embeddable
public class Address {
    private String streetNumber;
    private String complex;
    private String streetName;
    @NotBlank
    private String town;
    @NotBlank
    private String city;
    @NotBlank
    private String postalCode;
    @NotBlank
    private String province;
}
