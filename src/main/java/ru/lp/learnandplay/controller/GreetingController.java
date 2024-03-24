package ru.lp.learnandplay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private long counter = 0;

    @GetMapping("/greeting") //тест возвращающий json
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(++counter, String.format(template, name));
    }
}
