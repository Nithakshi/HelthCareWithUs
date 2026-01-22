package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(String fullName, String email, String password, String roleStr) {

        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already exists");
        }

        Role role = Role.valueOf(roleStr.toUpperCase()); // PATIENT/DOCTOR/ADMIN

        User user = new User(
                fullName,
                email,
                passwordEncoder.encode(password),
                role
        );

        return userRepository.save(user);
    }
}
