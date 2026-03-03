package com.example.cell.platform.domain.user;

import com.example.cell.platform.exception.BadRequestException;
import com.example.cell.platform.exception.ErrorCode;
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

    private static final String ERROR_NAME_IS_BLANK = "이름은 빈칸 또는 공백일 수 없습니다.";
    private static final String ERROR_PASSWORD_IS_BLANK = "비밀번호는 빈칸 또는 공백일 수 없습니다.";

    @Builder
    public User(Long id, String username, String password, Role role, LocalDateTime createdAt) {
        validateUsername(username);
        validatePassword(password);

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

    private void validateUsername(String username) {
        if (username == null || username.isBlank()) {
            throw new BadRequestException(ERROR_NAME_IS_BLANK, ErrorCode.U003);
        }
    }

    private void validatePassword(String password) {
        if (password == null || password.isBlank()) {
            throw new BadRequestException(ERROR_PASSWORD_IS_BLANK, ErrorCode.U004);
        }
    }
}
