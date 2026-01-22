package com.example.demo.controller;

import com.example.demo.dto.UserMeResponse;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/me")
    public UserMeResponse getCurrentUser(Authentication authentication) {
        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserMeResponse(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getRole().name(),   // if role is enum
                user.isEnabled()
        );
    }
}
