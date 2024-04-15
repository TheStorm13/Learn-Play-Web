package ru.lp.learnandplay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController { //контроллер для перехода по панели навигации
    @GetMapping("/education")
    public String getEducationPage() {
        return "education";
    }

    //ЭТИХ СТРАНИЧЕК КРОМЕ EDUCATION ЕЩЕ НЕТ!!!

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
    @GetMapping("/tutorial") //справочник (хз как назвать)
    public String getTutorialPage() {
        return "tutorial";
    }
    @GetMapping("/settings")
    public String getSettingsPage() {
        return "settings";
    }

}
