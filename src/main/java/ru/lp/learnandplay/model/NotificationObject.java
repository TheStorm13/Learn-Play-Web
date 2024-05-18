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
    @Column(name = "label")
    private String label;
    @Column(name = "message",columnDefinition = "text")
    private String message;
    @Column(name = "link")
    private String link;
    @Column(name = "date_note")
    private LocalDate dateNote;

    public NotificationObject() {
    }

    public NotificationObject(Long id, String label, String message, String link, LocalDate dateNote) {
        this.id = id;
        this.label = label;
        this.message = message;
        this.link = link;
        this.dateNote = dateNote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getDateNote() {
        return dateNote;
    }

    public void setDateNote(LocalDate dateNote) {
        this.dateNote = dateNote;
    }
}
