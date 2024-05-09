package ru.lp.learnandplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lp.learnandplay.model.Notification;
import ru.lp.learnandplay.model.Task;
import ru.lp.learnandplay.model.User;
import ru.lp.learnandplay.services.NotificationServiceImpl;
import ru.lp.learnandplay.services.UserService;
import ru.lp.learnandplay.services.UserServiceImpl;

import java.util.List;

@RestController
public class NotificationController {

    @Autowired
    private NotificationServiceImpl notificationService;

    @GetMapping("/getListNotification")
    public List<Notification> getListNotification(){
        return notificationService.getListNotification();
    }

//    @GetMapping("/newNotification")
//    public Notification newNotification(){
//        return notificationService.addNotification();
//    }



//    @GetMapping("/getDailyNotification")
//    public Task getDailyNotification() {
//        //проверить, сделан ли дейлик
//        //если да, то вернуть уведомление "вы не сделали дейлик"
//        return null;
//    }
}
