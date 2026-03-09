package com.example.cell.platform.infra.task;

import com.example.cell.platform.domain.crop.Crop;
import com.example.cell.platform.domain.task.Task;
import com.example.cell.platform.domain.task.TaskRepository;
import com.example.cell.platform.entity.CropEntity;
import com.example.cell.platform.entity.TaskEntity;
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
        TaskEntity entity = TaskEntity.of(task);
        for (Crop crop : task.getCrops()) {
            CropEntity cropEntity = CropEntity.of(crop);
            entity.addCrop(cropEntity);
        }
        TaskEntity saved = taskJpaRepository.save(entity);
        return Task.of(saved);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskJpaRepository.findById(id).map(Task::of);
    }

    @Override
    public List<Task> findAllByOrderByIdDesc() {
        return List.of();
    }
}
