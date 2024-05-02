package ru.lp.learnandplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lp.learnandplay.model.User;
import ru.lp.learnandplay.services.UserServiceImpl;

import java.util.Optional;

@RestController
public class EntryController {
    @Autowired
    private UserServiceImpl userService;
    @GetMapping("/getUser")
    public User getUser(){
        return userService.getUser();
    }
}
