package za.co.tfradebe.client_service.service;

import org.springframework.stereotype.Service;
import za.co.tfradebe.client_service.model.entities.ClientEntity;
import za.co.tfradebe.client_service.repository.ClientRepository;
import za.co.tfradebe.client_service.v1.ClientMapper;
import za.co.tfradebe.client_service.v1.dto.ClientCreateRequest;
import za.co.tfradebe.client_service.v1.dto.ClientUpdateRequest;
import za.co.tfradebe.client_service.v1.dto.model.ClientDto;
import za.co.tfradebe.client_service.v1.exception.NotFoundException;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public ClientDto create(ClientCreateRequest request) {
        var entity = clientMapper.map(request);
        entity = clientRepository.save(entity);
        return clientMapper.map(entity);
    }

    public ClientDto update(Long id, ClientUpdateRequest request) {
        var clientEntityOptional = clientRepository.findById(id);
        if (clientEntityOptional.isPresent()) {
            ClientEntity entity = clientEntityOptional.get();
            clientMapper.map(entity,request);
            entity = clientRepository.save(entity);
            return clientMapper.map(entity);
        }
        throw new NotFoundException("Client not found");
    }

    public List<ClientDto> getClients(){
        var entities = clientRepository.findAll();
        return clientMapper.map(entities);
    }

    public ClientDto getClientById(Long id){
        var entity = clientRepository.findById(id);
        if(entity.isPresent()){
            return clientMapper.map(entity.get());
        }
        throw new NotFoundException("Client not found");
    }

    public ClientDto deleteClientById(Long id){
        var entity = clientRepository.findById(id);
        if(entity.isPresent()){
            clientRepository.deleteById(id);
        }
        throw new NotFoundException("Client not found");
    }

    public ClientDto getClientByEmail(String email){
        var entity = clientRepository.findByEmail(email);
        return clientMapper.map(clientRepository.findByEmail(email));
    }
}
