package com.example.cell.platform.entity;

import com.example.cell.platform.domain.task.Task;
import com.example.cell.platform.domain.task.TaskStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tasks")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TaskEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status;

    @Column(nullable = false)
    private String originalFilename;

    @Column
    private String uploadedFilename;

    @Builder
    private TaskEntity(Long id, TaskStatus status, String originalFilename, String uploadedFilename) {
        this.id = id;
        this.status = status;
        this.originalFilename = originalFilename;
        this.uploadedFilename = uploadedFilename;
    }

    public static TaskEntity of(Task task) {
        return TaskEntity.builder()
                .id(task.getId())
                .status(task.getStatus())
                .originalFilename(task.getOriginalFilename())
                .uploadedFilename(task.getUploadedFilename())
                .build();
    }
}
