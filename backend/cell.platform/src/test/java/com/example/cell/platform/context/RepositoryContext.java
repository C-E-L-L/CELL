package com.example.cell.platform.context;

import com.example.cell.platform.config.JpaAuditingConfig;
import com.example.cell.platform.infra.user.UserCoreRepository;
import com.example.cell.platform.infra.user.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import({UserCoreRepository.class, JpaAuditingConfig.class})
public abstract class RepositoryContext {

    @Autowired
    protected UserJpaRepository userJpaRepository;
}
