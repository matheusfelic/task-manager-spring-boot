package com.example.taskmanager.repositories;

import com.example.taskmanager.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    Collection<Task> findAllByIsDoneEquals(boolean isDone);
}
