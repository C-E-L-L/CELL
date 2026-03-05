package com.example.cell.platform.infra.user;

import com.example.cell.platform.domain.user.User;
import com.example.cell.platform.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserCoreRepository implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public boolean existsByUsername(String username) {
        return false;
    }
}
