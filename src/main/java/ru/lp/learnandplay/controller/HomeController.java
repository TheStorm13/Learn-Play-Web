package ru.lp.learnandplay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.lp.learnandplay.model.User;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getHomePage() {
        return "main.html";
    }

    @GetMapping("/entry")
    public String getEntryPage() {
        return "entry.html";
    }

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration.html";
    }

    @GetMapping("/education")
    public String getEducationPage() {
        return "education.html";
    }

    @GetMapping("/quest")
    public String getQuestPage() {
        return "task.html";
    }
}
