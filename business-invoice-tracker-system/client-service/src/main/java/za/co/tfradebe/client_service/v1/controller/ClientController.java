package za.co.tfradebe.client_service.v1.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tfradebe.client_service.v1.dto.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @PostMapping("/create")
    public ResponseEntity<ClientCreateResponse> createClient(@Valid @RequestBody ClientCreateRequest request){
        return ResponseEntity.ok(new ClientCreateResponse());
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
