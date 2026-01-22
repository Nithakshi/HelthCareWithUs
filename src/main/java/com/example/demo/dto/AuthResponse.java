package com.example.demo.dto;

public class AuthResponse {
    private String token;
    private String role;
    private Long userId;
    private String fullName;
    private String email;

    public AuthResponse(String token, String role, Long userId, String fullName, String email) {
        this.token = token;
        this.role = role;
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
    }

    public String getToken() { return token; }
    public String getRole() { return role; }
    public Long getUserId() { return userId; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
}
