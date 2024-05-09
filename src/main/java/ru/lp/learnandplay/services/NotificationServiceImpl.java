package ru.lp.learnandplay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ru.lp.learnandplay.model.Notification;
import ru.lp.learnandplay.model.User;
import ru.lp.learnandplay.repository.NotificationRepository;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public List<Notification> getListNotification(){
        User user = userService.getUser();
        return notificationRepository.findAllByUserOrderByDateDesc(user);
    }
}
