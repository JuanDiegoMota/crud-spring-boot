package com.learningrest.todoapp.mapper;

import com.learningrest.todoapp.dto.TaskInDTO;
import com.learningrest.todoapp.persistence.entity.Task;
import com.learningrest.todoapp.persistence.entity.TaskStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task> {

    @Override
    public Task mapFrom(TaskInDTO in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setStatus(TaskStatus.ON_TIME);
        return task;
    }
}
