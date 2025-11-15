package za.co.tfradebe.invoice_service.service;

import org.springframework.stereotype.Service;
import za.co.tfradebe.invoice_service.exception.NotFoundException;
import za.co.tfradebe.invoice_service.repository.InvoiceRepository;
import za.co.tfradebe.invoice_service.v1.dto.CreateInvoiceRequest;
import za.co.tfradebe.invoice_service.v1.dto.UpdateInvoiceRequest;
import za.co.tfradebe.invoice_service.v1.dto.model.InvoiceDto;
import za.co.tfradebe.invoice_service.v1.mapper.InvoiceMapper;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    public InvoiceService(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    public InvoiceDto createInvoice(CreateInvoiceRequest request) {
        var entity = invoiceMapper.map(request);
        entity = invoiceRepository.save(entity);
        return invoiceMapper.map(entity);
    }

    public InvoiceDto getInvoice(Long id) {
        var entityOptional = invoiceRepository.findById(id);
        if(entityOptional.isPresent()) {
            var invoiceDto = invoiceMapper.map(entityOptional.get());
            return invoiceDto;
        }
        throw new NotFoundException("Invoice not found");
    }

    public InvoiceDto updateInvoice(Long id, UpdateInvoiceRequest request) {
        var entityOption = invoiceRepository.findById(id);
        if(entityOption.isPresent()) {
            var entity = entityOption.get();
            invoiceMapper.map(request, entity);
            invoiceRepository.save(entity);
            return invoiceMapper.map(entity);
        }
        throw new NotFoundException("Invoice not found");
    }
}
