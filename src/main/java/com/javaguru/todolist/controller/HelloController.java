package com.javaguru.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Random;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String hello(ModelMap modelMap) {
        Random randomGenerator = new Random();
        modelMap.addAttribute("message", randomGenerator.nextInt());
        return "hello";
    }

}
