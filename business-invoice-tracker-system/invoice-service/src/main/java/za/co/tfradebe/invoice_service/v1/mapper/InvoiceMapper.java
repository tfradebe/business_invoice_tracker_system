package za.co.tfradebe.invoice_service.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import za.co.tfradebe.invoice_service.entities.InvoiceEntity;
import za.co.tfradebe.invoice_service.v1.dto.CreateInvoiceRequest;
import za.co.tfradebe.invoice_service.v1.dto.UpdateInvoiceRequest;
import za.co.tfradebe.invoice_service.v1.dto.model.InvoiceDto;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    InvoiceEntity map(CreateInvoiceRequest request);
    InvoiceDto map(InvoiceEntity entity);
    void map(UpdateInvoiceRequest request,@MappingTarget InvoiceEntity entity);
}
