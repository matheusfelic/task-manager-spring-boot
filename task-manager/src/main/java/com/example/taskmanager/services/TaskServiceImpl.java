package com.example.taskmanager.services;

import com.example.taskmanager.entities.Task;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private static final Map<Integer, Task> taskList = new HashMap<>();

    @Override
    public void createTask(Task task) {
        taskList.put(task.getId(), task);
    }

    @Override
    public void updateTask(Task task) {
        taskList.remove(task.getId());
        taskList.put(task.getId(), task);
    }

    @Override
    public Task getTask(Integer id) {
        return taskList.get(id);
    }

    @Override
    public Collection<Task> getAllTasks() {
        return taskList.values();
    }

    @Override
    public Collection<Task> getAllTasks(boolean isDone) {
        return taskList.values().stream().filter(t -> t.isDone() == isDone).toList();
    }

    @Override
    public void deleteTask(Integer id) {
        taskList.remove(id);
    }

    @Override
    public void doTask(Integer id, boolean isDone) {
        Task task = taskList.get(id);
        task.setDone(isDone);
        taskList.remove(id);
        taskList.put(id, task);
    }
}
