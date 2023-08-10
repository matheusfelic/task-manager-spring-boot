package com.example.taskmanager.services;

import com.example.taskmanager.entities.Task;

import java.util.Collection;

public interface TaskService {
    void createTask(Task task);
    void updateTask(Task task);
    Task getTask(Integer id);
    Collection<Task> getAllTasks();
    Collection<Task> getAllTasks(boolean isDone);
    void deleteTask(Integer id);
    void doTask(Integer id, boolean isDone);
}
