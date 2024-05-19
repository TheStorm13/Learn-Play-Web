package ru.lp.learnandplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.lp.learnandplay.dto.response.ProfileDTO;
import ru.lp.learnandplay.services.Impl.ProfileServiceImpl;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileServiceImpl profileService;


    @GetMapping("/info")
    public ProfileDTO profilePage() {
        return profileService.profileInfo();
    }

    @PutMapping("/changeHero/{heroId}")
    public void changeHero(@PathVariable(name = "heroId")Long heroId) {
        profileService.changeHero(heroId);
    }

    @PutMapping("/changeName/{newName}")
    public void changeName(@PathVariable(name = "newName")String newName) {
        profileService.changeName(newName);
    }

    @GetMapping("/getIsDailyQuest")
    public boolean getIsDailyQuest() {
        return profileService.getIsDailyQuest();
    }
}
