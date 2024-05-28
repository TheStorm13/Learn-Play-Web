package ru.lp.learnandplay.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        if (SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser"))
            return "registration.html";
        return "education.html";
    }

    @GetMapping("/quest")
    public String getQuestPage() {
        return "task.html";
    }

    @GetMapping("/rating")
    public String getRatingPage() {
        return "rating.html";
    }

    @GetMapping("/tasks")
    public String getTasksPage() {
        return "constructor.html";
    }

    @GetMapping("/profile")
    public String getProfilePage() {
        return "profile.html";
    }

    @GetMapping("/profile/changeHero")
    public String getChangeHeroPage() {
        //todo
        return null;
    }

    @GetMapping("/tutorial")
    public String getTutorialPage() {
        return "guide.html";
    }

    @GetMapping("/settings")
    public String getSettingsPage() {
        return "setting.html";
    }

    @GetMapping("/success")
    public String getSuccessPage() {
        return "success.html";
    }

}
