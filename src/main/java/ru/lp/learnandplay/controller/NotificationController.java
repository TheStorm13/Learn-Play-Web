package ru.lp.learnandplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.lp.learnandplay.model.Notification;
import ru.lp.learnandplay.services.Impl.NotificationServiceImpl;

import java.util.List;

@RestController
public class NotificationController {

    @Autowired
    private NotificationServiceImpl notificationService;

    @GetMapping("/getListNotification")
    public List<Notification> getListNotification() {
        //todo проверять есть ли уведомление о дейлике за сегодня, если нет, то создавать его
        //todo возвращать список всех уведомлений у конкретного пользователя, которые не прочитаны
        return null;
    }

    @PutMapping("/viewedNotification")
    public boolean viewedNotification(@RequestBody Notification notification) {
        //todo обновлять статус у уведомления у конкретного пользователя на прочитано
        return false;
    }


//    @GetMapping("/getDailyNotification")
//    public Task getDailyNotification() {
//        //проверить, сделан ли дейлик
//        //если да, то вернуть уведомление "вы не сделали дейлик"
//        return null;
//    }
}
