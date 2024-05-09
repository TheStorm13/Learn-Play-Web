package ru.lp.learnandplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.lp.learnandplay.model.User;
import ru.lp.learnandplay.services.UserServiceImpl;

@Controller
public class RegistrationController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/registration")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        if(!userService.addUser(user))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ошибка при добавлении пользователя");;
        return ResponseEntity.status(HttpStatus.OK).body("Пользователь успешно добавлен");// Вернуть успешный статус и сообщение;
    }
}
