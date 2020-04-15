package com.javaguru.todolist.controller;

import com.javaguru.todolist.dto.TaskDTO;
import com.javaguru.todolist.domain.Task;
import com.javaguru.todolist.service.TaskService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public TaskDTO findTaskById(@PathVariable Long id) {
        Task task = service.findTaskById(id);
        return new TaskDTO(task.getId(), task.getName(), task.getDescription());
    }

    @PostMapping
    public TaskDTO create(@RequestBody TaskDTO request) {
        System.out.println("Received request: " + request);
        Task task = new Task();
        task.setName(request.getName());
        task.setDescription(request.getDescription());

        Task createdTask = service.createTask(task);

        return new TaskDTO(createdTask.getId(), createdTask.getName(), createdTask.getDescription());
    }
}
