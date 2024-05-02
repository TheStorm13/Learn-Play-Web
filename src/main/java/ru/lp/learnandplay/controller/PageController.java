package ru.lp.learnandplay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
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

    @GetMapping("/quest")
    public String getQuestPage() {
        return "task.html";
    }
}
