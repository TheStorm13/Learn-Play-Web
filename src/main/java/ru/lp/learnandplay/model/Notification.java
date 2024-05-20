package ru.lp.learnandplay.model;

import jakarta.persistence.*;

@Entity
@Table(name = "notification",uniqueConstraints= @UniqueConstraint(columnNames={"user_id", "note_obj_id"}))
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "note_obj_id")
    private NotificationObject notificationObject;
    @Column(name = "viewed")
    private boolean viewed;


    public Notification() {
    }

    public Notification(Long id, User user, NotificationObject notificationObject, boolean viewed) {
        this.id = id;
        this.user = user;
        this.notificationObject = notificationObject;
        this.viewed = viewed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public NotificationObject getNotificationObject() {
        return notificationObject;
    }

    public void setNotificationObject(NotificationObject notificationObject) {
        this.notificationObject = notificationObject;
    }

    public boolean isView() {
        return viewed;
    }

    public void setView(boolean viewed) {
        this.viewed = viewed;
    }
}
