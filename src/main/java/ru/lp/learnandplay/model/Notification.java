package ru.lp.learnandplay.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "notification")
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
    private NottificationObject notificationObject;
    @Column(name = "is_view")
    private boolean isView;


    public Notification() {
    }

    public Notification(Long id, User user, NottificationObject notificationObject, boolean isView) {
        this.id = id;
        this.user = user;
        this.notificationObject = notificationObject;
        this.isView = isView;
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

    public NottificationObject getNotificationObject() {
        return notificationObject;
    }

    public void setNotificationObject(NottificationObject notificationObject) {
        this.notificationObject = notificationObject;
    }

    public boolean isView() {
        return isView;
    }

    public void setView(boolean view) {
        isView = view;
    }
}
