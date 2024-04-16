package ru.lp.learnandplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.lp.learnandplay.model.User;
import ru.lp.learnandplay.repository.UsersRepository;

import java.util.List;


@RestController
public class mainController {
    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        usersRepository.save(user);
    }

    @PutMapping("/successtask")
    public Long addUser(@RequestBody Long idTask) {
        return idTask;
    }

    @GetMapping("/getUsers")
    public List<User> getUser(){
        return usersRepository.findAll();
    }
    @GetMapping("/save")
    public void saveUser(){
        usersRepository.save(new User());
    }

}
