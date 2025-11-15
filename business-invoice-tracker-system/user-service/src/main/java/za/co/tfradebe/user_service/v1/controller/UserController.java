package za.co.tfradebe.user_service.v1.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tfradebe.user_service.v1.dto.*;
import za.co.tfradebe.user_service.service.UserService;

import java.util.List;

import static za.co.tfradebe.user_service.v1.util.UserResponseUtil.createSuccessResponse;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/profile")
    public ResponseEntity<UserResponse> createProfile(@Valid @RequestBody CreateProfileRequest profileDTO){
        try {
            var userDto = userService.createProfile(profileDTO);
            var response = createSuccessResponse(List.of(userDto));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new RuntimeException("Failed to create profile");
        }
    }

    @GetMapping("/profile/{userId}")
    public ResponseEntity<UserResponse> getProfile(@PathVariable Long userId) {
        try {
            var userDto = userService.getProfileById(userId);
            if (userDto == null) {
                return ResponseEntity.notFound().build();
            }
            var response = createSuccessResponse(List.of(userDto));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> logging(@RequestBody @Valid LoginRequest loginRequest){
        try {
            var successLogin = userService.login(loginRequest.getEmail(), loginRequest.getUserpassword());
            var response = createSuccessResponse(List.of());
            response.setLogin(successLogin);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }

}
