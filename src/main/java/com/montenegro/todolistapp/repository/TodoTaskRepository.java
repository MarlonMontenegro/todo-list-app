package com.montenegro.todolistapp.repository;


import com.montenegro.todolistapp.model.TodoTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoTaskRepository extends JpaRepository<TodoTask, Integer> {

    List<TodoTask> findByIsActive(boolean isActive);

}
