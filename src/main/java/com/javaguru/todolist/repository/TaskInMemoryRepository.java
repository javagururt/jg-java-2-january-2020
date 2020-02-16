package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TaskInMemoryRepository {

    private Long taskIdSequence = 0L;
    private Map<Long, Task> repository = new HashMap<>();

    public Task save(Task task) {
        task.setId(taskIdSequence++);
        repository.put(task.getId(), task);
        return task;
    }

    public Optional<Task> findTaskById(Long id) {
        return Optional.ofNullable(repository.get(id));
    }

    public boolean existsByName(String name) {
        return repository.values().stream()
                .anyMatch(task -> task.getName().equalsIgnoreCase(name));
    }

    public Optional<Task> findTaskByName(String name) {
        return repository.values().stream()
                .filter(task -> task.getName().equalsIgnoreCase(name))
                .findFirst();
    }

}
