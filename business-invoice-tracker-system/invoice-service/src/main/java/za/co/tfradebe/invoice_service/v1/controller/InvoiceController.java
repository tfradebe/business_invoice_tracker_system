package za.co.tfradebe.invoice_service.v1.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tfradebe.invoice_service.v1.dto.CreateInvoiceRequest;
import za.co.tfradebe.invoice_service.v1.dto.InvoiceResponse;
import za.co.tfradebe.invoice_service.v1.dto.UpdateInvoiceRequest;

@RestController
@RequestMapping("/invoice")
@Slf4j
public class InvoiceController {

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
            return ResponseEntity.ok(new InvoiceResponse());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping("/{invoiceId}")
    public ResponseEntity<InvoiceResponse> getInvoice(@PathVariable String invoiceId) {
        try {
            return new ResponseEntity<>(new InvoiceResponse(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PostMapping("/{invoiceId}")
    public ResponseEntity<InvoiceResponse> updateInvoice(@PathVariable String invoiceId, @RequestBody @Valid UpdateInvoiceRequest request) {
        try {
            return new ResponseEntity<>(new InvoiceResponse(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

}
