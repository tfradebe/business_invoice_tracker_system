package za.co.tfradebe.user_service.service;

import org.springframework.stereotype.Service;
import za.co.tfradebe.user_service.exception.ProfileNotFoundException;
import za.co.tfradebe.user_service.model.mapper.UserProfileMapper;
import za.co.tfradebe.user_service.repository.UserProfileRepository;
import za.co.tfradebe.user_service.model.dto.UserProfileResponse;

@Service
public class UserService {

    private final UserProfileRepository userRepository;
    private final UserProfileMapper userProfileMapper;

    public UserService(UserProfileRepository userRepository, UserProfileMapper userProfileMapper) {
        this.userRepository = userRepository;
        this.userProfileMapper = userProfileMapper;
    }

    public UserProfileResponse createProfile(UserProfileResponse profileDTO) {
        var userProfileEntity = userProfileMapper.map(profileDTO);
        var userEntity = userRepository.save(userProfileEntity);
        return userProfileMapper.map(userEntity);
    }

    public UserProfileResponse getProfileById(Long id){
        var userEntity = userRepository.findById(id).orElseThrow(() -> new ProfileNotFoundException("User Profile Not Found"));
        return userProfileMapper.map(userEntity);
    }

    public UserProfileResponse updateProfile(Long id, UserProfileResponse profileDTO) {
        var userEntity = userRepository.findById(id).orElseThrow(() -> new ProfileNotFoundException("User Profile Not Found"));
        userProfileMapper.map(profileDTO, userEntity);
        userRepository.save(userEntity);
        return userProfileMapper.map(userEntity);
    }

}
