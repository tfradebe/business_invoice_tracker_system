package za.co.tfradebe.invoice_service.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import za.co.tfradebe.invoice_service.model.InvoiceStatus;
import za.co.tfradebe.invoice_service.model.LineItem;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "invoice")
@Data
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String invoiceNumber;
    private LocalDate invoiceDate;
    private LocalDate dueDate;
    private LocalDate paymentDate;
    private Long clientId;
    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;
    @ElementCollection
    @CollectionTable(name="invoice_items",joinColumns = @JoinColumn(name="invoice_id"))
    private Set<LineItem> lineItems;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
