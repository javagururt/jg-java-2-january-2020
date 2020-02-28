package com.javaguru.todolist.console;

import org.springframework.stereotype.Component;

@Component
class ExitAction implements Action {

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public String toString() {
        return "Exit";
    }
}
