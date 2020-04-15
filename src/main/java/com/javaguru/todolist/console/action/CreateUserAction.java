package com.javaguru.todolist.console.action;

import com.javaguru.todolist.domain.User;
import com.javaguru.todolist.service.UserService;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
class CreateUserAction implements Action {

    public static final String ACTION_NAME = "Create user";

    private final UserService service;

    CreateUserAction(UserService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter name: ");
        String name = scanner.nextLine();

        User user = new User();
        user.setName(name);

        User createdUser = service.save(user);
        System.out.println("Created user: " + createdUser);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
