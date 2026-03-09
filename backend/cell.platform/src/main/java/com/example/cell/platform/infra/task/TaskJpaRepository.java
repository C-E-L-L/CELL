package com.example.cell.platform.infra.task;

import com.example.cell.platform.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskJpaRepository extends JpaRepository<TaskEntity, Long> {
}
