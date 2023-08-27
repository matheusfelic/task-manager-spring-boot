package com.example.taskmanager.services;

import com.example.taskmanager.entities.Task;
import com.example.taskmanager.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Override
    public void saveTask(Task task) {
        repository.save(task);
    }

    @Override
    public Task getTask(Integer id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Collection<Task> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public Collection<Task> getAllTasks(boolean isDone) {
        return repository.findAllByIsDoneEquals(isDone);
    }

    @Override
    public void deleteTask(Integer id) {
        repository.deleteById(id);
    }

    @Transactional
    @Override
    public void doTask(Integer id, boolean isDone) {
        Task task = repository.getReferenceById(id);
        task.setDone(isDone);
        repository.save(task);
    }
}
