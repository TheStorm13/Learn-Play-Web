package ru.lp.learnandplay.controller;

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

    @GetMapping("/profile/changeHero")
    public String getChangeHeroPage() {
        //todo
        return null;
    }

    @GetMapping("/tutorial")
    public String getTutorialPage() {
        return "tutorial";
    }

    @GetMapping("/tutorial_page/{topicId}")
    public String getPageOfTutorial(@PathVariable(name = "topicId") String topicId) {
        return "index" + topicId;
    }

    @GetMapping("/settings")
    public String getSettingsPage() {
        return "settings";
    }


}
