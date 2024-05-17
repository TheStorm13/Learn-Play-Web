package ru.lp.learnandplay.model.Session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class QueueTaskByTopic {
    private Long topicId;
    private int queueSize;
    private int exp;

    public QueueTaskByTopic() {
    }

    public QueueTaskByTopic(Long topicId, int queueSize, int exp) {
        this.topicId = topicId;
        this.queueSize = queueSize;
        this.exp = exp;
    }


    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
