package com.example.cell.platform.domain.user;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class User {

    private Long id;
    private String username;
    private String password;
    private Role role;
    private LocalDateTime createdAt;

    @Builder
    public User(Long id, String username, String password, Role role, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
    }

    public static User create(String username, String password, Role role) {
        return User.builder()
                .username(username)
                .password(password)
                .role(role)
                .build();
    }
}
