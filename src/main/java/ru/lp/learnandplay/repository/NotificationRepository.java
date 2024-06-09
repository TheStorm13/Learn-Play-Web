package ru.lp.learnandplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.lp.learnandplay.model.Notification;
import ru.lp.learnandplay.model.User;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    @Query(value = "SELECT * FROM notification WHERE user_id = :userID AND note_obj_id = :notificationObjectID", nativeQuery = true)
    Notification findByUserAndNotificationObject(Long userID, Long notificationObjectID);

    @Query("SELECT n FROM Notification n WHERE n.user = :user ")
    List<Notification> findTodayNotificationsByUser(User user);
}
