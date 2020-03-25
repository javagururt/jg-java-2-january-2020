package com.javaguru.todolist.service;

import com.javaguru.todolist.domain.Task;
import com.javaguru.todolist.repository.TaskRepository;
import com.javaguru.todolist.service.validation.TaskValidationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class DefaultTaskService implements TaskService {

    private final TaskRepository repository;
    private final TaskValidationService validationService;

    @Autowired
    public DefaultTaskService(TaskRepository repository,
                              TaskValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    @Transactional
    public Task createTask(Task task) {
        validationService.validate(task);
        return repository.save(task);
    }

    public Task findTaskById(Long id) {
        return repository.findTaskById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found, id: " + id));
    }

    @Override
    public void deleteTaskById(Long id) {
        Task task = repository.findTaskById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found, id: " + id));
        repository.delete(task);
    }

    @Override
    public List<Task> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(Long id, Task newTask) {
        Task task = repository.findTaskById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found, id: " + id));

        task.setName(newTask.getName());
        task.setDescription(newTask.getDescription());

        repository.update(task);
    }

}