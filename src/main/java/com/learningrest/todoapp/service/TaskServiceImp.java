package com.learningrest.todoapp.service;

import com.learningrest.todoapp.dto.TaskInDTO;
import com.learningrest.todoapp.exceptions.NotFoundTaskException;
import com.learningrest.todoapp.mapper.TaskInDTOToTask;
import com.learningrest.todoapp.persistence.entity.Task;
import com.learningrest.todoapp.persistence.entity.TaskStatus;
import com.learningrest.todoapp.persistence.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImp implements TaskService {
    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskServiceImp(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Task createTask(TaskInDTO taskInDto) {
        Task task = mapper.mapFrom(taskInDto);
        return this.repository.save(task);
    }

    @Override
    public List<Task> findAllTask() {
        return this.repository.findAll();
    }

    @Override
    public List<Task> findAllByStatus(TaskStatus status) {
        return this.repository.findAllByStatus(status);
    }

    @Override
    @Transactional
    public void updateTaskAsFinished(Long id) {
        Optional<Task> optionalTask =  this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new NotFoundTaskException("Task with id "+ id+" was not found", HttpStatus.NOT_FOUND);
        }
        this.repository.markTaskAsFinished(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Optional<Task> optionalTask =  this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new NotFoundTaskException("Task with id "+ id+" was not found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }
}
