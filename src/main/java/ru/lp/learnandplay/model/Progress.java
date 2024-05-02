package ru.lp.learnandplay.model;

import jakarta.persistence.*;

@Entity
@Table(name = "progress")
public class Progress {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @Column(name = "step")
    private Short step;
    @Column(name = "count")
    private int count = 0;

    public Progress(User user, Topic topic, Short step, int count) {
        this.user = user;
        this.topic = topic;
        this.step = step;
        this.count = count;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Short getStep() {
        return step;
    }

    public void setStep(Short step) {
        this.step = step;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
