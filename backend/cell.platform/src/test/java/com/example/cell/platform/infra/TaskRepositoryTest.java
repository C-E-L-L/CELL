package com.example.cell.platform.infra;

import com.example.cell.platform.context.RepositoryContext;
import com.example.cell.platform.domain.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TaskRepositoryTest extends RepositoryContext {

    @Autowired
    private TaskRepository taskRepository;
}
