package za.co.tfradebe.user_service.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tfradebe.user_service.model.dto.UserProfileResponse;
import za.co.tfradebe.user_service.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/profile")
    public ResponseEntity<UserProfileResponse> createProfile(@Valid @RequestBody UserProfileResponse profileDTO){
        var userProfileDTO = userService.createProfile(profileDTO);
        return ResponseEntity.ok(userProfileDTO);
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<UserProfileResponse> getProfile(@PathVariable Long userId) {
        var userDto = userService.getProfileById(userId);
        if(userDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDto);
    }

}
