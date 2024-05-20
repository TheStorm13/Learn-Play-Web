package ru.lp.learnandplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.lp.learnandplay.model.Notification;
import ru.lp.learnandplay.model.NotificationObject;
import ru.lp.learnandplay.model.User;

import java.util.List;

public interface NotificationObjectRepository extends JpaRepository<NotificationObject, Long> {
    @Query(value = "SELECT * FROM notification_object WHERE date_note  = current_date",nativeQuery = true)
    NotificationObject findByCurrentDate();

    @Query(value = "SELECT * FROM notification_object WHERE note_obj_id IN (SELECT note_obj_id FROM notification WHERE user_id = :userId AND viewed = false)",nativeQuery = true)
    List<NotificationObject> findActiveAllByUser(Long userId);
}
