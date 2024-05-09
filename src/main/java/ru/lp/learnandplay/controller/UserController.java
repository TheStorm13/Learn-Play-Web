package ru.lp.learnandplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lp.learnandplay.model.User;
import ru.lp.learnandplay.services.UserServiceImpl;

@RestController
@RequestMapping("/registration")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/addUser")
    public ResponseEntity<HttpStatus> addUser(@RequestBody User user) {
        if (userService.addUser(user))
            return ResponseEntity.status(HttpStatus.CREATED).build();
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    //todo rating
}
