package za.co.tfradebe.user_service.db;

import org.mapstruct.Mapper;
import za.co.tfradebe.user_service.db.entities.UserProfileEntity;
import za.co.tfradebe.user_service.dto.UserProfileDTO;

public class mapper {
    @Mapper(componentModel = "spring")
    public static interface UserProfileMapper {
        UserProfileDTO map(UserProfileEntity userProfileEntity);

        UserProfileEntity map(UserProfileDTO userProfileDTO);
    }
}
