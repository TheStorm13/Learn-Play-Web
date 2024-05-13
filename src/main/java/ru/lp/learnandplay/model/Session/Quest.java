package ru.lp.learnandplay.model.Session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Component
@SessionScope
public class Quest {
    private List<QueueTaskByTopic> listTaskByTopics;
    private int successTask = 0;
    private int failedTask = 0;
    private int allTask = 0;

    public Quest(List<Integer> listCountTask) {
        this.listTaskByTopics = new ArrayList<QueueTaskByTopic>();
        Random random = new Random();
        int count;
        int exp;
        for (int i = 0; i < listCountTask.size(); i++) {
            count = listCountTask.get(i);
            allTask += count;
            exp = random.nextInt(3) + 1;
            this.listTaskByTopics.add(new QueueTaskByTopic((long) (i + 1), count, exp));
        }
    }

    public Quest(Long topicIdQuest, int count, int exp) {
        this.listTaskByTopics = new ArrayList<QueueTaskByTopic>();
        for (int i = 0; i < 18; i++) {
            long topicId = i + 1;
            count = topicId == topicIdQuest ? count : 0;
            allTask += count;
            this.listTaskByTopics.add(new QueueTaskByTopic((long) (i + 1), count, exp));
        }
    }

    public Quest() {
        this.listTaskByTopics = new ArrayList<QueueTaskByTopic>();
        Random random = new Random();
        int count;
        int exp;
        for (int i = 0; i < 18; i++) {
            long topicId = i + 1;
            count = random.nextInt(2);
            allTask += count;
            exp = random.nextInt(3) + 1;
            this.listTaskByTopics.add(new QueueTaskByTopic(topicId, count, exp));
        }
    }

    public List<QueueTaskByTopic> getListTaskByTopics() {
        return listTaskByTopics;
    }

    public void setListTaskByTopics(List<QueueTaskByTopic> listTaskByTopics) {
        this.listTaskByTopics = listTaskByTopics;
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

    public Quest downCountTopic(Long topicId) {
        int index = (int) (topicId - 1);
        QueueTaskByTopic queueTaskByTopic = this.listTaskByTopics.get(index);
        queueTaskByTopic.setQueueSize(queueTaskByTopic.getQueueSize() - 1);
        this.listTaskByTopics.set(index, queueTaskByTopic);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Quest:\n");
        for (QueueTaskByTopic task : this.listTaskByTopics) {
            str.append(task.getTopicId());
            str.append(" ");
            str.append(task.getQueueSize());
            str.append("\n");
        }
        return str.toString();
    }

}
