package ru.lp.learnandplay.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //для работы с RestFul сервисами(http запросы) -> писать необходимые аннотации к методам
public class mainController {

    @GetMapping("/")
    public String getWelcomePage() {
        return "home";
    }
    //'/education/topic{}tast{}'

    @GetMapping("/entry")
    public String getEntryPage() {
        return "entry";
    }

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }

}
