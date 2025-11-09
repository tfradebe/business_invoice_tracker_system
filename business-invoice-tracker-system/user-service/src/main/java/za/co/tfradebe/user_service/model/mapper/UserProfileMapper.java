package za.co.tfradebe.user_service.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import za.co.tfradebe.user_service.model.dto.UserProfileResponse;
import za.co.tfradebe.user_service.model.entities.UserProfileEntity;

@Mapper(componentModel = "spring")

public interface UserProfileMapper {
    UserProfileResponse map(UserProfileEntity userProfileEntity);
    UserProfileEntity map(UserProfileResponse userProfileResponse);
    void map(UserProfileResponse userProfileResponse, @MappingTarget UserProfileEntity userProfileEntity);
}
