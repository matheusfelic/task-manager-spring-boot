package com.example.taskmanager.controllers;

import com.example.taskmanager.entities.Task;
import com.example.taskmanager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class TaskController {

    @Autowired
    public TaskService taskService;

    @GetMapping(value = "/tasks/get/{id}")
    public ResponseEntity<Task> getTask(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(taskService.getTask(id), HttpStatus.OK);
    }

    @GetMapping(value = "/tasks")
    public ResponseEntity<Collection<Task>> getTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping(value="tasks/{isDone}")
    public ResponseEntity<Collection<Task>> getTasks(@PathVariable("isDone") boolean isDone) {
        return new ResponseEntity<>(taskService.getAllTasks(isDone), HttpStatus.OK);
    }

    @PostMapping(value = "/tasks/create")
    public ResponseEntity<String> createTask(@RequestBody Task task) {
        taskService.saveTask(task);
        return new ResponseEntity<>("Your task was added successfully!", HttpStatus.OK);
    }

    @PutMapping(value = "/tasks/update")
    public ResponseEntity<String> updateTask(@RequestBody Task task) {
        taskService.saveTask(task);
        return new ResponseEntity<>("Your task was updated successfully!", HttpStatus.OK);
    }

    @DeleteMapping(value = "/tasks/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Integer id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>("Your task was deleted successfully!", HttpStatus.OK);
    }

    @PutMapping(value = "/tasks/do/{id}/{isDone}")
    public ResponseEntity<String> doTask(@PathVariable("id") Integer id, @PathVariable("isDone") boolean isDone) {
        taskService.doTask(id, isDone);
        return new ResponseEntity<>(isDone ? "Your task is done!" : "Your task is undone!", HttpStatus.OK);
    }

}
