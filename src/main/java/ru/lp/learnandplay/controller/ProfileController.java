package ru.lp.learnandplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.lp.learnandplay.dto.response.ProfileDTO;
import ru.lp.learnandplay.services.Impl.ProfileServiceImpl;
import ru.lp.learnandplay.services.Impl.UserServiceImpl;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileServiceImpl profileService;
    @Autowired
    private UserServiceImpl userService;

    //get data for the profile page
    @GetMapping("/info")
    public ProfileDTO profilePage() {
        return profileService.profileInfo();
    }

    //get a daily quest completion status
    @GetMapping("/isDailyQuest")
    public boolean isDailyQuest() {
        return userService.getUser().isDailyQuest();
    }

    @PutMapping("/changeHero/{heroId}")
    public void changeHero(@PathVariable(name = "heroId") Long heroId) {
        profileService.changeHero(heroId);
    }

    @PutMapping("/changeName/{newName}")
    public void changeName(@PathVariable(name = "newName") String newName) {
        profileService.changeName(newName);
    }
}
