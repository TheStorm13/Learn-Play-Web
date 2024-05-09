package ru.lp.learnandplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.lp.learnandplay.model.User;
import ru.lp.learnandplay.services.UserServiceImpl;

import java.util.Optional;

@RestController
public class EntryController {
    @Autowired
    private UserServiceImpl userService;
    @GetMapping("/getUser")
    public Optional<User> getUser(){
        return userService.getUser();
    }

    @PostMapping
    public boolean entry(@RequestBody User user){
        return true;
    }
}
