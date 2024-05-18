package ru.lp.learnandplay.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lp.learnandplay.model.Notification;
import ru.lp.learnandplay.model.NotificationObject;
import ru.lp.learnandplay.model.User;
import ru.lp.learnandplay.repository.NotificationObjectRepository;
import ru.lp.learnandplay.repository.NotificationRepository;
import ru.lp.learnandplay.services.NotificationService;

import java.time.LocalDate;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationObjectRepository notificationObjectRepository;


    @Override
    public List<NotificationObject> getListNotification() {
        User user = userService.getUser();
        return notificationObjectRepository.findActiveAllByUser(user.getId());
    }

    @Override
    public Notification addNotification() {
        Notification notification = new Notification();
        User user = userService.getUser();
        notification.setUser(user);
        notificationRepository.save(notification);

        NotificationObject notificationObject = new NotificationObject();
        notificationObject.setDateNote(LocalDate.now());

        notificationObjectRepository.save(notificationObject);

        notification.setNotificationObject(notificationObject);
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
        NotificationObject notificationObject = notificationObjectRepository.findByCurrentDate();
        if (notificationObject == null) {
            notificationObject = new NotificationObject();
            notificationObject.setDateNote(LocalDate.now());
            notificationObject.setLabel("Ежедневный квест");
            notificationObject.setMessage("Юный исследователь по имени Элис решает встать на защиту своего родного места и отправляется в эпическое путешествие, чтобы разгадать загадку возросшей опасности. Она собирает команду отважных путешественников и отправляется на поиски древних артефактов, способных защитить деревню от темных сил.");
            notificationObject.setLink("/tasks");
            //todo Добавить текст для уведомления дейлика
            notificationObjectRepository.save(notificationObject);
        }
        Notification notification = notificationRepository.findByUserAndNotificationObject(user.getId(), notificationObject.getId());
        if (notification == null) {
            notification = new Notification();
            notification.setUser(user);
            notification.setNotificationObject(notificationObject);
            notificationRepository.save(notification);
        }

    }

    @Override
    public void viewedNotification(Long noteObjId) {
        User user = userService.getUser();
        Notification notification = notificationRepository.findByUserAndNotificationObject(user.getId(), noteObjId);
        notification.setView(true);
        notificationRepository.save(notification);
    }


}
