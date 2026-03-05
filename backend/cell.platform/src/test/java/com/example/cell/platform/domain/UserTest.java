package com.example.cell.platform.domain;

import com.example.cell.platform.domain.user.Role;
import com.example.cell.platform.domain.user.User;
import com.example.cell.platform.entity.UserEntity;
import com.example.cell.platform.exception.BadRequestException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Nested
    class User는 {

        @Test
        void 정상적인_인자가_들어오면_객체가_생성된다() {
            // given
            String username = "student";
            String password = "password";
            Role role = Role.STUDENT;

            // when
            User user = User.create(username, password, role);

            // then
            assertThat(user.getUsername()).isEqualTo(username);
            assertThat(user.getPassword()).isEqualTo(password);
            assertThat(user.getRole()).isEqualTo(role);
            assertThat(user.getCreatedAt()).isNull();
        }

        @ParameterizedTest
        @MethodSource("provideInvalidContent")
        void 잘못된_인자가_들어오면_예외가_발생한다(String username, String password) {
            // given
            Role role = Role.STUDENT;

            // expect
            assertThrows(BadRequestException.class, () ->
                    User.builder()
                            .username(username)
                            .password(password)
                            .role(role)
                            .build()
            );
        }

        private static Stream<Arguments> provideInvalidContent() {
            return Stream.of(
                    Arguments.of(null, "password"),
                    Arguments.of("", "password"),
                    Arguments.of("username", null),
                    Arguments.of("username", "")
            );
        }

        @Nested
        class of_메서드는 {

            @Test
            void UserEntity를_받아_User로_변환하다() {
                // given
                Long id = 1L;
                String username = "student";
                String password = "password";
                Role role = Role.STUDENT;

                UserEntity entity = UserEntity.builder()
                        .id(id)
                        .username(username)
                        .password(password)
                        .role(role)
                        .build();

                // when
                User user = User.of(entity);

                // then
                assertThat(user.getId()).isEqualTo(id);
                assertThat(user.getUsername()).isEqualTo(username);
                assertThat(user.getPassword()).isEqualTo(password);
                assertThat(user.getRole()).isEqualTo(role);
            }
        }
    }
}
