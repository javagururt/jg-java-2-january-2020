package com.javaguru.todolist.console;

import com.javaguru.todolist.domain.Task;
import com.javaguru.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CreateTaskAction implements Action {

    private final TaskService taskService;

    @Autowired
    public CreateTaskAction(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter task name: ");
        String name = scanner.nextLine();
        System.out.println("Enter task description: ");
        String description = scanner.nextLine();

        Task task = new Task();
        task.setName(name);
        task.setDescription(description);

        Long id = taskService.createTask(task);
        System.out.println("Result: " + id);
    }

    @Override
    public String toString() {
        return "Create Task";
    }
}
