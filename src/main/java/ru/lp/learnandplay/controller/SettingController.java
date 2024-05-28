package ru.lp.learnandplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.lp.learnandplay.services.Impl.UserServiceImpl;

@RestController
@RequestMapping("/setting")
public class SettingController {
    @Autowired
    private UserServiceImpl userService;

    @PutMapping("/changeEmail/{newEmail}")
    public boolean changeEmail(@PathVariable(name = "newEmail") String newEmail) {
        return userService.changeEmail(newEmail);
    }

    @PutMapping("/changePassword/{oldPassword}/{newPassword}")
    public boolean changePassword(@PathVariable(name = "oldPassword") String oldPassword, @PathVariable(name = "newPassword") String newPassword) {
        return userService.changePassword(oldPassword, newPassword);
    }

    @PutMapping("/switchDailyNotice/{active}")
    public void changeDailyNotification(@PathVariable(name = "active")boolean active) {
        userService.switchDailyNotice(active);
    }


}
