package com.montenegro.todolistapp.service;

import com.montenegro.todolistapp.exceptions.TaskNotFoundException;
import com.montenegro.todolistapp.exceptions.TaskServiceException;
import com.montenegro.todolistapp.exceptions.TaskValidationException;
import com.montenegro.todolistapp.model.TodoTask;
import com.montenegro.todolistapp.repository.TodoTaskRepository;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoTaskService {

    private final TodoTaskRepository taskRepository;

    @Autowired
    public TodoTaskService(TodoTaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional
    public void save(TodoTask task) {
        try {
            taskRepository.save(task);
        } catch (DataIntegrityViolationException ex) {
            throw new TaskValidationException("Task validation failed", ex);
        } catch (Exception e) {
            throw new TaskServiceException("Error saving task", e);
        }
    }

    public TodoTask findById(int id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task Not Found"));
    }

    List<TodoTask> findAll() {
        return taskRepository.findAll();
    }

    public List<TodoTask> findByStatus(boolean isActive) {
        return taskRepository.findByIsActive(isActive);
    }

    @Transactional
    void update(int id, TodoTask updateTask) {

        TodoTask existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));

        try {
            BeanUtils.copyProperties(updateTask, existingTask, "id");
            taskRepository.save(existingTask);

        } catch (Exception e) {
            throw new TaskServiceException("Error updating Task", e);
        }
    }

    @Transactional
    void delete(int id) {

        TodoTask taskToDelete = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task Not Found"));

        try {
            taskRepository.delete(taskToDelete);
        } catch (Exception e) {
            throw new TaskServiceException("Error deleting task", e);
        }
    }

}
