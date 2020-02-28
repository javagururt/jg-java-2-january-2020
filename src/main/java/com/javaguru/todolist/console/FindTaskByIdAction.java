package com.javaguru.todolist.console;

import com.javaguru.todolist.domain.Task;
import com.javaguru.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FindTaskByIdAction implements Action {

    private final TaskService taskService;

    @Autowired
    public FindTaskByIdAction(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter task id: ");
        Long id = scanner.nextLong();
        Task task = taskService.findTaskById(id);
        System.out.println(task);
    }

    @Override
    public String toString() {
        return "Find Task By Id";
    }
}
