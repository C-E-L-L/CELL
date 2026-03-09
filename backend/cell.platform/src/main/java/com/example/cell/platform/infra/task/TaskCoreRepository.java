package com.example.cell.platform.infra.task;

import com.example.cell.platform.domain.task.Task;
import com.example.cell.platform.domain.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TaskCoreRepository implements TaskRepository {

    private final TaskJpaRepository taskJpaRepository;

    @Override
    public Task save(Task task) {
        return null;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Task> findAllByOrderByIdDesc() {
        return List.of();
    }
}
