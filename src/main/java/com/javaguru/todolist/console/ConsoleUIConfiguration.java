package com.javaguru.todolist.console;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ConsoleUIConfiguration {

    private final Action createTaskAction;
    private final Action findTaskByIdAction;
    private final Action exitAction;

    public ConsoleUIConfiguration(Action createTaskAction,
                                  Action findTaskByIdAction,
                                  Action exitAction) {
        this.createTaskAction = createTaskAction;
        this.findTaskByIdAction = findTaskByIdAction;
        this.exitAction = exitAction;
    }

    @Bean
    public List<Action> actions() {
        List<Action> actions = new ArrayList<>();
        actions.add(createTaskAction);
        actions.add(findTaskByIdAction);
        actions.add(exitAction);
        return actions;
    }
}
