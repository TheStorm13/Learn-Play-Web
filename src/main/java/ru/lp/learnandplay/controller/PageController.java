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

    @GetMapping("/education")
    public String getEducationPage() {
        return "education.html";
    }

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration.html";
    }

    @GetMapping("/quest")
    public String getQuestPage() {
        return "task.html";
    }

    @GetMapping("/rating")
    public String getRatingPage() {
        return "rating";
    }

    @GetMapping("/tasks")
    public String getTasksPage() {
        return "tasks";
    }

    @GetMapping("/profile")
    public String getProfilePage() {
        return "profile";
    }

    @GetMapping("/tutorial")
    public String getTutorialPage() {
        return "tutorial";
    }

    @GetMapping("/settings")
    public String getSettingsPage() {
        return "settings";
    }







}
