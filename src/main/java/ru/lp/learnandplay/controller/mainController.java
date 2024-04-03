package ru.lp.learnandplay.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.lp.learnandplay.model.test;

@Controller //для работы с RestFul сервисами(http запросы) -> писать необходимые аннотации к методам
public class mainController {
    @GetMapping("/")
    public String getWelcomePage() {
        return "home";
    }

    @GetMapping("/entry")
    public String getEntryPage() {
        return "entry";
    }
    @GetMapping("/g")
    @ResponseBody
    public test getG() {
        return new test("1",1);
    }
}
