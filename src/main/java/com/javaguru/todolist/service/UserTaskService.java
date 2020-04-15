package com.javaguru.todolist.service;

import com.javaguru.todolist.domain.Task;
import com.javaguru.todolist.domain.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserTaskService {

    private final UserService userService;
    private final TaskService taskService;

    public UserTaskService(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @Transactional
    public void assignTaskToUser(Long userId, Long taskId) {
        User user = userService.findUserById(userId);
        Task task = taskService.findTaskById(taskId);
        task.setUser(user);
//        user.getTasks().add(task);
    }
}
