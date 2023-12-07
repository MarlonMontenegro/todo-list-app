package com.montenegro.todolistapp.exceptions;

public class TaskServiceException extends RuntimeException {

    public TaskServiceException(String name, Throwable cause) {
        super(name, cause);
    }
}
