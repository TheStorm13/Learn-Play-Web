package ru.lp.learnandplay.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "notification_object")
public class NotificationObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_obj_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "note_id")
    private Notification notification;
    @Column(name = "label")
    private String label;
    @Column(name = "message")
    private String message;
    @Column(name = "link")
    private String link;
    @Column(name = "date")
    private LocalDate date;

    public NotificationObject() {
    }

    public NotificationObject(Long id, Notification notification, String label, String message, String link, LocalDate date) {
        this.id = id;
        this.notification = notification;
        this.label = label;
        this.message = message;
        this.link = link;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
