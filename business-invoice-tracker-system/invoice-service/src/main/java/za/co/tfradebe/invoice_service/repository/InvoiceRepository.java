package za.co.tfradebe.invoice_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tfradebe.invoice_service.entities.InvoiceEntity;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
    List<InvoiceEntity> findByClientId(Long userId);
    InvoiceEntity findByInvoiceNumber(String invoiceNumber);
}
