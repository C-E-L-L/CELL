package com.example.cell.platform.infra.user;

import com.example.cell.platform.domain.user.User;
import com.example.cell.platform.domain.user.UserRepository;
import com.example.cell.platform.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserCoreRepository implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User save(User user) {
        UserEntity entity = UserEntity.of(user);
        UserEntity saved = userJpaRepository.save(entity);
        return User.of(saved);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        Optional<UserEntity> userEntity = userJpaRepository.findByUsername(username);
        return userEntity.map(User::of);
    }

    @Override
    public boolean existsByUsername(String username) {
        return false;
    }
}
