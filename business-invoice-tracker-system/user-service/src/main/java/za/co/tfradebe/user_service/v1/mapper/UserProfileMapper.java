package za.co.tfradebe.user_service.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import za.co.tfradebe.user_service.v1.dto.CreateProfileRequest;
import za.co.tfradebe.user_service.v1.dto.CreateProfileResponse;
import za.co.tfradebe.user_service.model.entities.UserProfileEntity;
import za.co.tfradebe.user_service.v1.dto.UpdateProfileRequest;
import za.co.tfradebe.user_service.v1.dto.model.UserDto;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserDto map(UserProfileEntity userProfileEntity);
    @Mapping(target = "userPassword", source = "userPassword", qualifiedByName = "charsToString")
    UserProfileEntity map(CreateProfileRequest createProfileRequest);
    void map(UpdateProfileRequest createProfileRequest, @MappingTarget UserProfileEntity userProfileEntity);

    @Named("charsToString")
    default String mapCharsToString(char[] characters) {
        if(characters == null){
            return null;
        }
        return characters.toString();
    }
}
