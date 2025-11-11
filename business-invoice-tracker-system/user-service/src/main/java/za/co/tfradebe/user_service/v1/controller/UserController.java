package za.co.tfradebe.user_service.v1.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tfradebe.user_service.v1.dto.CreateProfileRequest;
import za.co.tfradebe.user_service.v1.dto.CreateProfileResponse;
import za.co.tfradebe.user_service.service.UserService;
import za.co.tfradebe.user_service.v1.dto.LoginRequest;
import za.co.tfradebe.user_service.v1.dto.LoginResponse;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/profile")
    public ResponseEntity<CreateProfileResponse> createProfile(@Valid @RequestBody CreateProfileRequest profileDTO){
        var userProfileDTO = userService.createProfile(profileDTO);
        return ResponseEntity.ok(userProfileDTO);
    }

    @GetMapping("/profile/{userId}")
    public ResponseEntity<CreateProfileResponse> getProfile(@PathVariable Long userId) {
        var userDto = userService.getProfileById(userId);
        if(userDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> logging(@RequestBody @Valid LoginRequest loginRequest){
        var successLogin = userService.login(loginRequest.getEmail(),loginRequest.getUserpassword());
        var response = new LoginResponse();
        response.setSuccess(successLogin);
        return ResponseEntity.ok(response);
    }

}
