package ru.lp.learnandplay.services;

import ru.lp.learnandplay.model.Notification;

import java.util.List;

public interface NotificationService {
    public List<Notification> getListNotification();

    public Notification addNotification();

    public boolean deleteNotification();
}
