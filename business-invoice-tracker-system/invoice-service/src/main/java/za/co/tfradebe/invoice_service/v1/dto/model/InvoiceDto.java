package za.co.tfradebe.invoice_service.v1.dto.model;

import lombok.Data;
import za.co.tfradebe.invoice_service.model.InvoiceStatus;
import za.co.tfradebe.invoice_service.model.LineItem;

import java.time.LocalDate;
import java.util.Set;

@Data
public class InvoiceDto {
    private Long id;
    private String invoiceNumber;
    private LocalDate invoiceDate;
    private LocalDate dueDate;
    private LocalDate paymentDate;
    private Long clientId;
    private InvoiceStatus status;
    private Set<LineItem> lineItems;
}
