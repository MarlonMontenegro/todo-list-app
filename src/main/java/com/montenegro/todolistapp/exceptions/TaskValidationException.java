package com.montenegro.todolistapp.exceptions;

public class TaskValidationException extends RuntimeException {

    public TaskValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
