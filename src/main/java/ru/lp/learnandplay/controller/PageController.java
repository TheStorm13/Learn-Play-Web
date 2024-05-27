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

    @GetMapping("/tutorialOne")
    public String getPage1OfTutorial() {
        return "tutorial/page1.html";
    }
    @GetMapping("/tutorialTwo")
    public String getPage2OfTutorial() {
        return "tutorial/page2.html";
    }

    @GetMapping("/tutorialThree")
    public String getPage3OfTutorial() {
        return "tutorial/page3.html";
    }
    @GetMapping("/tutorialFour")
    public String getPage4OfTutorial() {
        return "tutorial/page4.html";
    }

    @GetMapping("/tutorialFive")
    public String getPage5OfTutorial() {
        return "tutorial/page5.html";
    }

    @GetMapping("/tutorialSix")
    public String getPage6OfTutorial() {
        return "tutorial/page6.html";
    }

    @GetMapping("/tutorialSeven")
    public String getPage7OfTutorial() {
        return "tutorial/page7.html";
    }

    @GetMapping("/tutorialEight")
    public String getPage8OfTutorial() {
        return "tutorial/page8.html";
    }

    @GetMapping("/tutorialNine")
    public String getPage9OfTutorial() {
        return "tutorial/page9.html";
    }

    @GetMapping("/tutorialTen")
    public String getPage10OfTutorial() {
        return "tutorial/page10.html";
    }

    @GetMapping("/tutorialEleven")
    public String getPage11OfTutorial() {
        return "tutorial/page11.html";
    }

    @GetMapping("/tutorialTwelve")
    public String getPage12OfTutorial() {
        return "tutorial/page12.html";
    }

    @GetMapping("/tutorialThirteen")
    public String getPage13OfTutorial() {
        return "tutorial/page13.html";
    }

    @GetMapping("/tutorialFourteen")
    public String getPage14OfTutorial() {
        return "tutorial/page14.html";
    }

    @GetMapping("/tutorialFifteen")
    public String getPage15OfTutorial() {
        return "tutorial/page15.html";
    }

    @GetMapping("/tutorialSixteen")
    public String getPage16OfTutorial() {
        return "tutorial/page16.html";
    }

    @GetMapping("/tutorialSeventeen")
    public String getPage17OfTutorial() {
        return "tutorial/page17.html";
    }


    @GetMapping("/tutorialEighteen")
    public String getPage18OfTutorial() {
        return "tutorial/page18.html";
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
