package za.co.tfradebe.client_service.v1.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tfradebe.client_service.service.ClientService;
import za.co.tfradebe.client_service.v1.dto.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public ResponseEntity<ClientCreateResponse> createClient(@Valid @RequestBody ClientCreateRequest request){
        var client = clientService.create(request);
        var response = ClientResponseUtil.createSuccessResponse(List.of(client));
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<GetClientResponse> getClients(){
        return ResponseEntity.ok(new GetClientResponse());
    }

    @PostMapping("/update/{clientId}")
    public ResponseEntity<ClientUpdateResponse> updateClient(@PathVariable String clientId, @Valid @RequestBody ClientUpdateRequest request){
        return ResponseEntity.ok(new ClientUpdateResponse());
    }

    @DeleteMapping("/delete/{clientId}")
    public ResponseEntity<ClientDeleteResponse> deleteClient(@PathVariable String clientId){
        return ResponseEntity.ok(new ClientDeleteResponse());
    }
}
