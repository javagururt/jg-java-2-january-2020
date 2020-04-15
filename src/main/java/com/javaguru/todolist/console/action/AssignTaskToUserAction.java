package com.javaguru.todolist.console.action;

import com.javaguru.todolist.service.UserTaskService;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
class AssignTaskToUserAction implements Action {

    public static final String ACTION_NAME = "Assign task to user";

    private final UserTaskService service;

    AssignTaskToUserAction(UserTaskService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter task id:");
        Long taskId = scanner.nextLong();
        System.out.println("Please enter user id:");
        Long userId = scanner.nextLong();

        service.assignTaskToUser(userId, taskId);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
