package com.learningrest.todoapp.controller;

import com.learningrest.todoapp.dto.TaskInDTO;
import com.learningrest.todoapp.persistence.entity.Task;
import com.learningrest.todoapp.persistence.entity.TaskStatus;
import com.learningrest.todoapp.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO task) {
        return this.taskService.createTask(task);
    }

    @GetMapping
    public List<Task> findAllTask() {
        return this.taskService.findAllTask();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllTaskByStatus(@PathVariable(value = "status") TaskStatus status) {
        return this.taskService.findAllByStatus(status);
    }

    @PatchMapping("/updated_task/{id}")
    public ResponseEntity<String> updateTaskAsFinished(@PathVariable(value = "id") Long id) {
        this.taskService.updateTaskAsFinished(id);
        return ResponseEntity.ok().body("Task with id: " + id + " was update");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable(value = "id") Long id) {
        this.taskService.deleteById(id);
        return ResponseEntity.ok().body("Task with id: " + id + " was delete");
    }


}
