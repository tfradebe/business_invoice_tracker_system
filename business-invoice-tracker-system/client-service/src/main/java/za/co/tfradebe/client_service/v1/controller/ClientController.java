package za.co.tfradebe.client_service.v1.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tfradebe.client_service.service.ClientService;
import za.co.tfradebe.client_service.v1.dto.*;

import java.util.List;

import static za.co.tfradebe.client_service.v1.dto.ClientResponseUtil.createSuccessResponse;

@RestController
@RequestMapping("/client")
@Slf4j
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public ResponseEntity<ClientResponse> createClient(@Valid @RequestBody ClientCreateRequest request){
        try {
            var client = clientService.create(request);
            var response = createSuccessResponse(List.of(client));
            return ResponseEntity.ok(response);
        } catch (Exception e){
            log.error(e.getMessage());
            throw e;
        }
    }

    @GetMapping
    public ResponseEntity<ClientResponse> getClients(){
        try {
            var clients = clientService.getClients();
            var response = createSuccessResponse(clients);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            log.error(e.getMessage());
            throw e;
        }
    }

    @PostMapping("/update/{clientId}")
    public ResponseEntity<ClientResponse> updateClient(@PathVariable Long clientId, @Valid @RequestBody ClientUpdateRequest request){
        try {
            var client = clientService.update(clientId, request);
            var response = createSuccessResponse(List.of(client));
            return ResponseEntity.ok(response);
        } catch (Exception e){
            log.error(e.getMessage());
            throw e;
        }
    }

    @GetMapping("/update/{clientId}")
    public ResponseEntity<ClientResponse> getClientById(@PathVariable Long clientId){
        try {
            var client = clientService.getClientById(clientId);
            var response = createSuccessResponse(List.of(client));
            return ResponseEntity.ok(response);
        } catch (Exception e){
            log.error(e.getMessage());
            throw e;
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<ClientResponse> getClientByEmail(@PathVariable String email){
        try {
            var client = clientService.getClientByEmail(email);
            var response = createSuccessResponse(List.of(client));
            return ResponseEntity.ok(response);
        } catch (Exception e){
            log.error(e.getMessage());
            throw e;
        }
    }

    @DeleteMapping("/delete/{clientId}")
    public ResponseEntity<ClientDeleteResponse> deleteClient(@PathVariable Long clientId){
        return ResponseEntity.ok(new ClientDeleteResponse());
    }
}
