package za.co.tfradebe.client_service.v1;

import org.mapstruct.Mapper;
import za.co.tfradebe.client_service.model.entities.ClientEntity;
import za.co.tfradebe.client_service.v1.dto.ClientCreateRequest;
import za.co.tfradebe.client_service.v1.dto.model.ClientDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDto map(ClientEntity clientEntity);
    ClientEntity map(ClientDto clientDto);
    List<ClientDto> map(List<ClientEntity> clientEntity);

    ClientEntity map(ClientCreateRequest clientCreateRequest);
}
