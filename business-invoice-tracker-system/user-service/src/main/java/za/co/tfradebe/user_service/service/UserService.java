package za.co.tfradebe.user_service.service;

import org.springframework.stereotype.Service;
import za.co.tfradebe.user_service.exception.ProfileNotFoundException;
import za.co.tfradebe.user_service.v1.dto.CreateProfileRequest;
import za.co.tfradebe.user_service.v1.dto.CreateProfileResponse;
import za.co.tfradebe.user_service.v1.dto.UpdateProfileRequest;
import za.co.tfradebe.user_service.v1.mapper.UserProfileMapper;
import za.co.tfradebe.user_service.repository.UserProfileRepository;

@Service
public class UserService {

    private final UserProfileRepository userRepository;
    private final UserProfileMapper userProfileMapper;
    private final PasswordEncoderService passwordEncoderService;

    public UserService(UserProfileRepository userRepository, UserProfileMapper userProfileMapper, PasswordEncoderService passwordEncoderService) {
        this.userRepository = userRepository;
        this.userProfileMapper = userProfileMapper;
        this.passwordEncoderService = passwordEncoderService;
    }

    public CreateProfileResponse createProfile(CreateProfileRequest profileDTO) {
        profileDTO.setUserpassword(passwordEncoderService.encode(profileDTO.getUserpassword()));
        var userProfileEntity = userProfileMapper.map(profileDTO);
        var userEntity = userRepository.save(userProfileEntity);
        return userProfileMapper.map(userEntity);
    }

    public CreateProfileResponse getProfileById(Long id){
        var userEntity = userRepository.findById(id).orElseThrow(() -> new ProfileNotFoundException("User Profile Not Found"));
        return userProfileMapper.map(userEntity);
    }

    public CreateProfileResponse updateProfile(Long id, UpdateProfileRequest profileDTO) {
        var userEntity = userRepository.findById(id).orElseThrow(() -> new ProfileNotFoundException("User Profile Not Found"));
        userProfileMapper.map(profileDTO, userEntity);
        userRepository.save(userEntity);
        return userProfileMapper.map(userEntity);
    }

}
