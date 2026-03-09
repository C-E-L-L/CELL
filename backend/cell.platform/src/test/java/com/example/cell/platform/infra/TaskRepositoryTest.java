package com.example.cell.platform.infra;

import com.example.cell.platform.context.RepositoryContext;
import com.example.cell.platform.domain.crop.CellType;
import com.example.cell.platform.domain.crop.Crop;
import com.example.cell.platform.domain.task.Task;
import com.example.cell.platform.domain.task.TaskRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class TaskRepositoryTest extends RepositoryContext {

    @Autowired
    private TaskRepository taskRepository;

    @Nested
    class save_메서드는 {

        @Test
        void 과제를_저장한다() {
            // given
            Task task = Task.create("original_file.jpg", "uploaded_file.jpg");

            // when
            Task saved = taskRepository.save(task);

            // then
            assertAll(
                    () -> assertThat(saved.getId()).isNotNull(),
                    () -> assertThat(saved.getOriginalFilename()).isEqualTo("original_file.jpg"),
                    () -> assertThat(saved.getUploadedFilename()).isEqualTo("uploaded_file.jpg"),
                    () -> assertThat(saved.getCreatedAt()).isNotNull()
            );
        }

        @Test
        void 과제와_크롭을_함께_저장한다() {
            // given
            Task task = Task.create("original_file.jpg", "uploaded_file.jpg");
            Crop crop = Crop.create("crop.jpg", "[10, 20, 30, 40]", CellType.Band, 1.0);
            task.getCrops().add(crop);

            // when
            Task saved = taskRepository.save(task);

            // then
            assertAll(
                    () -> assertThat(saved.getCrops()).hasSize(1),
                    () -> assertThat(saved.getCrops().get(0).getId()).isNotNull(),
                    () -> assertThat(saved.getCrops().get(0).getCropFilename()).isEqualTo("crop.jpg")
            );
        }
    }
}
