package za.co.tfradebe.user_service.v1.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tfradebe.user_service.v1.dto.CreateProfileRequest;
import za.co.tfradebe.user_service.v1.dto.CreateProfileResponse;
import za.co.tfradebe.user_service.service.UserService;
import za.co.tfradebe.user_service.v1.dto.LoginRequest;

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

    @GetMapping("/profile/{id}")
    public ResponseEntity<CreateProfileResponse> getProfile(@PathVariable Long userId) {
        var userDto = userService.getProfileById(userId);
        if(userDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> logging(@RequestBody @Valid LoginRequest loginRequest){

    }

}
