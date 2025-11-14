package za.co.tfradebe.invoice_service.v1.dto;

import lombok.Data;
import za.co.tfradebe.invoice_service.v1.dto.error.ErrorDetail;
import za.co.tfradebe.invoice_service.v1.dto.model.InvoiceDto;

import java.util.List;

@Data
public class InvoiceResponse {
    private String status;
    private String code;
    private Boolean login;
    private List<ErrorDetail> error;
    private List<InvoiceDto> data;
}
