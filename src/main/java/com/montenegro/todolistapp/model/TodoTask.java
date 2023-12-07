package com.montenegro.todolistapp.model;

import jakarta.persistence.*;

/**
* Represents a task entity that can be stored in a database.
 * Each task has an identifier, a description, and an active status.
* */
@Entity
@Table(name = "tasks")
public class TodoTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String task;
    private boolean isActive;

    public TodoTask() {
    }

    public TodoTask(int id, String task, boolean isActive) {
        this.id = id;
        this.task = task;
        this.isActive = isActive;
    }

    public TodoTask(String task, boolean isActive) {
        this.task = task;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}
