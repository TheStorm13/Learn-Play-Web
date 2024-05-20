package ru.lp.learnandplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.lp.learnandplay.model.Notification;
import ru.lp.learnandplay.model.NotificationObject;
import ru.lp.learnandplay.services.Impl.NotificationServiceImpl;

import java.util.List;

@RestController
public class NotificationController {
    //todo удалять старые уведомления спустя неделю
    @Autowired
    private NotificationServiceImpl notificationService;

    @GetMapping("/getListNotification")
    public List<NotificationObject> getListNotification() {
        notificationService.isTodayDaily();
        return notificationService.getListNotification();
    }

    @PutMapping("/viewedNotification/{note_obj_id}")
    public void viewedNotification(@PathVariable(name = "note_obj_id") Long noteObjId) {
        notificationService.viewedNotification(noteObjId);
    }

}
