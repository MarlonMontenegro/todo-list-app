package com.montenegro.todolistapp;

import com.montenegro.todolistapp.model.TodoTask;
import com.montenegro.todolistapp.service.TodoTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoTaskServiceTest {

    @Autowired
    private TodoTaskService todoTaskService;

    @Test
    public void testSaveTask() {
        TodoTask task = new TodoTask();
        String testString = "This is a Test...";

        task.setTask(testString);
        todoTaskService.save(task);

        TodoTask savedTask = todoTaskService.findById(task.getId());
        assertNotNull(savedTask);
        assertEquals(testString, savedTask.getTask());
    }

    @Test
    public void testFindTaskById() {
        String testString = "OMG, I AM A TEST!...";
        TodoTask task = new TodoTask();

        task.setTask(testString);
        todoTaskService.save(task);

        TodoTask foundTask = todoTaskService.findById(task.getId());
        assertEquals(testString, foundTask.getTask());
        System.out.println("TEST SUCCESSFUL ID: " + task.getId() +  " FOUND..");
        System.out.println("id, " + foundTask.getId() + "description, " + foundTask.getTask());
    }

    @Test
    public void testFindAllTask(){

    }
}
