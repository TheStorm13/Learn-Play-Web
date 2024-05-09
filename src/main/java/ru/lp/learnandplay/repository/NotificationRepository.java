package ru.lp.learnandplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.lp.learnandplay.model.Notification;
import ru.lp.learnandplay.model.User;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Long, Notification> {
    @Query("SELECT n FROM Notification n WHERE n.user = :user ORDER BY n.date DESC")
    List<Notification> findAllByUserOrderByDateDesc(@Param("user") User user);
}
