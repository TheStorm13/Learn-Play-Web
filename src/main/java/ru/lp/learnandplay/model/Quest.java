package ru.lp.learnandplay.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import ru.lp.learnandplay.dto.request.QuestDTO;
import ru.lp.learnandplay.dto.response.ProgressDTO;
import ru.lp.learnandplay.model.Session.QueueTaskByTopic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Entity
@Table(name = "quest")

public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quest_id")
    private Long idQuest;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ElementCollection(targetClass = Long.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "list_task", joinColumns = @JoinColumn(name = "quest_id"))
    @Column(name = "task")
    private List<Long> listTask = null;
    @Column(name = "type_quest")
    private TypeQuest typeQuest;
    @Column(name = "topic_step")
    private int topicStep = 0;
    @Column(name = "topic_id")
    private long topicId = 0;
    @Column(name = "success_task")
    private int successTask = 0;
    @Column(name = "failed_task")
    private int failedTask = 0;
    @Column(name = "all_task")
    private int allTask = 0;


    public Quest(Long idQuest, User user, List<Long> listTask, TypeQuest typeQuest, int topicStep, long topicId, int successTask, int failedTask, int allTask) {
        this.idQuest = idQuest;
        this.user = user;
        this.listTask = listTask;
        this.typeQuest = typeQuest;
        this.topicStep = topicStep;
        this.topicId = topicId;
        this.successTask = successTask;
        this.failedTask = failedTask;
        this.allTask = allTask;
    }

    public Quest() {
    }


    public Long getIdQuest() {
        return idQuest;
    }

    public void setIdQuest(Long idQuest) {
        this.idQuest = idQuest;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Long> getListTask() {
        return listTask;
    }

    public void setListTask(List<Long> listTask) {
        this.listTask = listTask;
    }

    public TypeQuest getTypeQuest() {
        return typeQuest;
    }

    public void setTypeQuest(TypeQuest typeQuest) {
        this.typeQuest = typeQuest;
    }

    public int getTopicStep() {
        return topicStep;
    }

    public void setTopicStep(int topicStep) {
        this.topicStep = topicStep;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public int getSuccessTask() {
        return successTask;
    }

    public void setSuccessTask(int successTask) {
        this.successTask = successTask;
    }

    public int getFailedTask() {
        return failedTask;
    }

    public void setFailedTask(int failedTask) {
        this.failedTask = failedTask;
    }

    public int getAllTask() {
        return allTask;
    }

    public void setAllTask(int allTask) {
        this.allTask = allTask;
    }
}
