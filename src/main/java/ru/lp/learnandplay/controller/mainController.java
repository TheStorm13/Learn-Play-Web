package ru.lp.learnandplay.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.lp.learnandplay.model.test;

@Controller //для работы с RestFul сервисами(http запросы) -> писать необходимые аннотации к методам
public class mainController {


    @GetMapping("/")
    public String getMain() {
        return "main.html";
    }
    @RequestMapping ("/entry.html")
    public String getEntry() {
        return "entry.html";
    }

    @GetMapping("/test")
    public test getTest() {
        return (new test(1l, "Test"));
    }
}
