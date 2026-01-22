package com.example.demo.dto;

public record UserMeResponse(
        Long id,
        String fullName,
        String email,
        String role,
        boolean enabled
) {}
