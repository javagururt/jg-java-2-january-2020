package com.javaguru.todolist.service;

import com.javaguru.todolist.domain.User;
import com.javaguru.todolist.repository.HibernateUserRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final HibernateUserRepository repository;

    UserService(HibernateUserRepository repository) {
        this.repository = repository;
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User findUserById(Long id) {
//        Optional<User> userOptional = repository.findById(id);
//        if (!userOptional.isPresent()) {
//            throw new IllegalArgumentException("User not found, id: " + id);
//        }
//        return userOptional.get();
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found, id: " + id));
    }

    public void update(User user) {
        repository.update(user);
    }
}
