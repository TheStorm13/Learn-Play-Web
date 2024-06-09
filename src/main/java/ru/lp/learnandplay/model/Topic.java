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
    @Column(name = "count_task")
    private int countTask;

    public Topic() {
    }

    public Topic(Long idTopic, String nameTopic, int countTask) {
        this.idTopic = idTopic;
        this.nameTopic = nameTopic;
        this.countTask = countTask;
    }

    public String getNameTopic() {
        return nameTopic;
    }

    public void setNameTopic(String nameTopic) {
        this.nameTopic = nameTopic;
    }

    public int getCountTask() {
        return countTask;
    }

    public void setCountTask(int countTask) {
        this.countTask = countTask;
    }

    public Long getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(Long idTopic) {
        this.idTopic = idTopic;
    }
}
