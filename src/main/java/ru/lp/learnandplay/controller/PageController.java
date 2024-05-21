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

    @GetMapping("/tutorial/{topicId}")
    public String getPageOfTutorial(@PathVariable(name = "topicId") int topicId) {
        //todo протестить
        return "page" + String.valueOf(topicId) + ".html";
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
