package ru.lp.learnandplay.model;

import jakarta.persistence.*;

@Entity
@Table(name = "resolved_task")
public class ResolvedTask {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @Column(name = "count")
    private int count= 0;

    public ResolvedTask(User user, Task task, int count) {
        this.user = user;
        this.task = task;
        this.count =count;
    }

    public ResolvedTask() {

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
}
