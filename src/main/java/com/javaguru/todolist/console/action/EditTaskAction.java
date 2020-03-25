package com.javaguru.todolist.console.action;

import com.javaguru.todolist.domain.Task;
import com.javaguru.todolist.service.TaskService;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
class EditTaskAction implements Action {

    private static final String ACTION_NAME = "Edit task";

    private final TaskService service;

    EditTaskAction(TaskService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter id: ");
        Long id = Long.valueOf(scanner.nextLine());

        System.out.println("Please enter new name: ");
        String newName = scanner.nextLine();
        System.out.println("Please enter new description: ");
        String newDescription = scanner.nextLine();

        Task task = new Task();
        task.setName(newName);
        task.setDescription(newDescription);
        service.update(id, task);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
