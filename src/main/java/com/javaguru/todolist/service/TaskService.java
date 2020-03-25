package com.javaguru.todolist.service;

import com.javaguru.todolist.domain.Task;

import java.util.List;

public interface TaskService {

    Task createTask(Task task);

    Task findTaskById(Long id);

    void deleteTaskById(Long id);

    List<Task> findAll();

    void update(Long id, Task task);
}
