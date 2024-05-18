package ru.lp.learnandplay.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lp.learnandplay.model.Notification;
import ru.lp.learnandplay.model.NotificationObject;
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
    public List<NotificationObject> getListNotification() {
        User user = userService.getUser();
        //todo возвращать по user активные уведомления
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

        //todo удаляем старые уведомления спустя неделю при авторизации пользователя
        return false;
    }

    @Override
    public void isTodayDaily() {
        User user = userService.getUser();
        //todo проверяем для user дейлик на сегодня
        //todo если его нет, то создаем

    }

    @Override
    public void viewedNotification(NotificationObject notificationObject) {
        User user = userService.getUser();
        //todo найти у user уведомление с notificationObject и изменить его статус на прочитано

    }


}
