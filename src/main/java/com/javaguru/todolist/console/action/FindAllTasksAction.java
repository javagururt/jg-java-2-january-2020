package com.javaguru.todolist.console.action;

import com.javaguru.todolist.domain.Task;
import com.javaguru.todolist.service.TaskService;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
class FindAllTasksAction implements Action {

    private static final String ACTION_NAME = "Find all tasks";
    private final TaskService service;

    FindAllTasksAction(TaskService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        List<Task> tasks = service.findAll();
        System.out.println("Tasks: " + tasks);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
