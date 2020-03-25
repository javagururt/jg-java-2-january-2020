package com.javaguru.todolist.console.action;

import com.javaguru.todolist.service.TaskService;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
class DeleteTaskByIdAction implements Action {

    public static final String ACTION_NAME = "Delete task by id";

    private final TaskService service;

    DeleteTaskByIdAction(TaskService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter id: ");
        Long id = scanner.nextLong();
        service.deleteTaskById(id);
    }


    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
