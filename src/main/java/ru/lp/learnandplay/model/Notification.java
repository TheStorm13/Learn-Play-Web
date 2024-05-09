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
    @Column(name = "label")
    private String label;
    @Column(name = "message")
    private String message;
    @Column(name = "link")
    private String link;
    @Column(name = "date")
    private LocalDate date;

    public Notification() {
    }

    public Notification(Long id, User user, String label, String message, String link, LocalDate date) {
        this.id = id;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
