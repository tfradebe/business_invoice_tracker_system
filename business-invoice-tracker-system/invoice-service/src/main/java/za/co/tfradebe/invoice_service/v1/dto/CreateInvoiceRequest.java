package za.co.tfradebe.invoice_service.v1.dto;

import lombok.Data;
import za.co.tfradebe.invoice_service.model.InvoiceStatus;
import java.time.LocalDate;

@Data
public class CreateInvoiceRequest {
    private LocalDate invoiceDate;
    private LocalDate dueDate;
    private LocalDate paymentDate;
    private Long clientId;
    private InvoiceStatus status;
}
