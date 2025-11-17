package za.co.tfradebe.user_service.service;

import org.springframework.stereotype.Service;
import za.co.tfradebe.user_service.exception.NotFoundException;
import za.co.tfradebe.user_service.v1.dto.CreateProfileRequest;
import za.co.tfradebe.user_service.v1.dto.UpdateProfileRequest;
import za.co.tfradebe.user_service.v1.dto.model.UserDto;
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

    public UserDto createProfile(CreateProfileRequest profileDTO) {
        var encodedPassword = passwordEncoderService.encode(profileDTO.getUserPassword());
        var userProfileEntity = userProfileMapper.map(profileDTO);
        userProfileEntity.setUserPassword(encodedPassword);
        var userEntity = userRepository.save(userProfileEntity);
        return userProfileMapper.map(userEntity);
    }

    public UserDto getProfileById(Long id){
        var userEntity = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User Profile Not Found"));
        return userProfileMapper.map(userEntity);
    }

    public UserDto getProfileByEmail(String email){
        var userEntity = userRepository.findByEmail(email);
        return userProfileMapper.map(userEntity);
    }

    public UserDto updateProfile(Long id, UpdateProfileRequest profileDTO) {
        var userEntity = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User Profile Not Found"));
        userProfileMapper.map(profileDTO, userEntity);
        userRepository.save(userEntity);
        return userProfileMapper.map(userEntity);
    }

    public boolean login(String email, char[] password){
        var userEntity = userRepository.findByEmail(email);
        if(userEntity == null){
            return false;
        }
        var matches = passwordEncoderService.matches(password,userEntity.getUserPassword());
        if(matches){
            var upgradeEncoding = passwordEncoderService.upgradeEncoding(userEntity.getUserPassword());
            if(upgradeEncoding){
                userEntity.setUserPassword(passwordEncoderService.encode(password));
            }
        }
        return matches;
    }

}
