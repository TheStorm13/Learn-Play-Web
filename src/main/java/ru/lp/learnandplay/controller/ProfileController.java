package ru.lp.learnandplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lp.learnandplay.dto.request.ProfileDTO;
import ru.lp.learnandplay.services.ProfileServiceImpl;
import ru.lp.learnandplay.services.UserServiceImpl;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileServiceImpl profileService;
    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/info")
    public ProfileDTO profilePage() {
        return profileService.profileInfo();
    }

    @PostMapping("/changeHero")
    public void changeHero(Long heroId) {
        profileService.changeHero(heroId);
    }

    @PostMapping("/changeName")
    public void changeName(String name) {
        profileService.changeName(name);
    }
}
