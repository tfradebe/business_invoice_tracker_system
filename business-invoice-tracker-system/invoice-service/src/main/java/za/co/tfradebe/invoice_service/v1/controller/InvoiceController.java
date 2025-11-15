package za.co.tfradebe.invoice_service.v1.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tfradebe.invoice_service.service.InvoiceService;
import za.co.tfradebe.invoice_service.v1.dto.CreateInvoiceRequest;
import za.co.tfradebe.invoice_service.v1.dto.InvoiceResponse;
import za.co.tfradebe.invoice_service.v1.dto.UpdateInvoiceRequest;

import java.util.List;

import static za.co.tfradebe.invoice_service.util.InvoiceResponseUtil.createSuccessResponse;

@RestController
@RequestMapping("/invoice")
@Slf4j
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/all/{clientId}")
    public ResponseEntity<InvoiceResponse> getInvoices(@PathVariable String clientId) {
        try {
            return new ResponseEntity<>(new InvoiceResponse(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PostMapping
    public ResponseEntity<InvoiceResponse> createInvoice(@RequestBody @Valid CreateInvoiceRequest request) {
        try {
            var invoiceDto = invoiceService.createInvoice(request);
            var response = createSuccessResponse(invoiceDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping("/{invoiceId}")
    public ResponseEntity<InvoiceResponse> getInvoice(@PathVariable Long invoiceId) {
        try {
            var invoiceDto = invoiceService.getInvoice(invoiceId);
            var response = createSuccessResponse(invoiceDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PostMapping("/{invoiceId}")
    public ResponseEntity<InvoiceResponse> updateInvoice(@PathVariable Long invoiceId, @RequestBody @Valid UpdateInvoiceRequest request) {
        try {
            var invoiceDto = invoiceService.updateInvoice(invoiceId,request);
            var response = createSuccessResponse(invoiceDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

}
