package ru.lp.learnandplay.model;

import jakarta.persistence.*;

@Entity
@Table(name = "progress", uniqueConstraints= @UniqueConstraint(columnNames={"user_id", "topic_id"}))
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @Column(name = "step")
    private Short step = 0;
    @Column(name = "count")
    private int count = 0;

    public Progress(Long id, User user, Topic topic, Short step, int count) {
        this.id = id;
        this.user = user;
        this.topic = topic;
        this.step = step;
        this.count = count;
    }

    public Progress() {

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Progress{" +
                "id=" + id +
                ", user=" + user +
                ", topic=" + topic +
                ", step=" + step +
                ", count=" + count +
                '}';
    }
}
