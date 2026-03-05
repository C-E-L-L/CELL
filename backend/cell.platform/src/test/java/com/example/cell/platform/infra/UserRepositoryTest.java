package com.example.cell.platform.infra;

import com.example.cell.platform.context.RepositoryContext;
import com.example.cell.platform.domain.user.Role;
import com.example.cell.platform.domain.user.User;
import com.example.cell.platform.domain.user.UserRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class UserRepositoryTest extends RepositoryContext {

    @Autowired
    private UserRepository userRepository;

    @Nested
    class save_메서드는 {

        @Test
        void 사용자를_저장한다() {
            // given
            String username = "student";
            String password = "password";
            Role role = Role.STUDENT;

            User user = User.builder()
                    .username(username)
                    .password(password)
                    .role(role)
                    .build();

            // when
            User savedUser = userRepository.save(user);

            // then
            assertAll(
                    () -> assertThat(savedUser.getId()).isNotNull(),
                    () -> assertThat(savedUser.getUsername()).isEqualTo(username),
                    () -> assertThat(savedUser.getPassword()).isEqualTo(password),
                    () -> assertThat(savedUser.getRole()).isEqualTo(role),
                    () -> assertThat(savedUser.getCreatedAt()).isNotNull()
            );
        }
    }
}
