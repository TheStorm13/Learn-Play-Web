package ru.lp.learnandplay.services;

import ru.lp.learnandplay.model.Notification;
import ru.lp.learnandplay.model.NotificationObject;

import java.util.List;

public interface NotificationService {
    public List<NotificationObject> getListNotification();

    public Notification addNotification();

    public boolean deleteNotification();

    public void isTodayDaily();

    public void viewedNotification(Long noteObjId);
}
