package ru.lp.learnandplay.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lp.learnandplay.model.Notification;
import ru.lp.learnandplay.model.User;
import ru.lp.learnandplay.repository.NotificationRepository;
import ru.lp.learnandplay.services.NotificationService;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private NotificationRepository notificationRepository;


    @Override
    public List<Notification> getListNotification() {
        User user = userService.getUser();
        //todo
        return null;
    }

    @Override
    public Notification addNotification() {
        Notification notification = new Notification();
        User user = userService.getUser();
        notification.setUser(user);
        notificationRepository.save(notification);
        return notification;
    }

    @Override
    public boolean deleteNotification() {
        //todo должно ли быть тело у запроса?
        //todo прописать необходимые функции в сервисах
        return false;
    }
}
