package ru.lp.learnandplay.model;

import jakarta.persistence.*;

@Entity
@Table(name = "resolved_task", uniqueConstraints= @UniqueConstraint(columnNames={"user_id", "task_id"}))
public class ResolvedTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
    @Column(name = "count")
    private int count;

    public ResolvedTask(Long id, User user, Task task, int count) {
        this.id = id;
        this.user = user;
        this.task = task;
        this.count = count;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
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
}
