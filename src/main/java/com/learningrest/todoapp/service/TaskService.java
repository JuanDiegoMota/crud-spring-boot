package com.learningrest.todoapp.service;

import com.learningrest.todoapp.dto.TaskInDTO;
import com.learningrest.todoapp.persistence.entity.Task;
import com.learningrest.todoapp.persistence.entity.TaskStatus;

import java.util.List;


public interface TaskService {

    Task createTask(TaskInDTO taskInDto);

    List<Task> findAllTask();

    List<Task> findAllByStatus(TaskStatus status);

    void updateTaskAsFinished(Long id);

    void deleteById(Long id);

}
