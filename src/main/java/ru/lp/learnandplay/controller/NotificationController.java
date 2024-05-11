package ru.lp.learnandplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
        //создать для всего этого функции в сервисах
        return notificationService.getListNotification();
    }

    @DeleteMapping("deleteNotofocations")
    public boolean deleteNotification() {
        //todo изменить возвращаемый тип
        //todo должно ли быть тело у запроса
        //todo прописать необходимые функции в сервисах
        return false;
    }


//    @GetMapping("/getDailyNotification")
//    public Task getDailyNotification() {
//        //проверить, сделан ли дейлик
//        //если да, то вернуть уведомление "вы не сделали дейлик"
//        return null;
//    }
}
