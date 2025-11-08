package za.co.tfradebe.user_service.service;

import org.springframework.stereotype.Service;
import za.co.tfradebe.user_service.db.entities.UserProfileEntity;
import za.co.tfradebe.user_service.db.repository.UserProfileRepository;
import za.co.tfradebe.user_service.dto.UserProfileDTO;

@Service
public class UserService {

    private final UserProfileRepository userRepository;

    public UserService(UserProfileRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserProfileEntity getUserProfile(String userId, UserProfileDTO profileDTO) {

    }

}
