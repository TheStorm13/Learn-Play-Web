package ru.lp.learnandplay.model;

import jakarta.persistence.*;

@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private Long idTopic;
    @Column(name = "name_topic")
    private String nameTopic;

    public Topic() {
    }

    public Topic(String nameTopic) {
        this.nameTopic = nameTopic;
    }

    public String getNameTopic() {
        return nameTopic;
    }

    public void setNameTopic(String nameTopic) {
        this.nameTopic = nameTopic;
    }
}
