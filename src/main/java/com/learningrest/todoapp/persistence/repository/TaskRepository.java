package com.learningrest.todoapp.persistence.repository;

import com.learningrest.todoapp.persistence.entity.Task;
import com.learningrest.todoapp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByStatus(TaskStatus status);

    @Modifying
    @Query(value = "UPDATE TASKS SET FINISHED=true WHERE ID=:id", nativeQuery = true)
    void markTaskAsFinished(@Param("id") Long id);
}
