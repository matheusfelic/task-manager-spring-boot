package com.example.taskmanager.entities;

import lombok.Data;

@Data
public class Task {

    private Integer id;

    private String name;

    private boolean isDone;
}
