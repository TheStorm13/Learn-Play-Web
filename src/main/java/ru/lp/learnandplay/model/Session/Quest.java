package ru.lp.learnandplay.model.Session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import ru.lp.learnandplay.dto.request.QuestDTO;
import ru.lp.learnandplay.dto.response.ProgressDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Component
@SessionScope
public class Quest {
    private List<QueueTaskByTopic> listTaskByTopics = null;
    private ProgressDTO isTopicQuest = null;
    private int successTask = 0;
    private int failedTask = 0;
    private int allTask = 0;

    public Quest(List<Integer> listCountTask) {
        this.listTaskByTopics = new ArrayList<QueueTaskByTopic>();
        Random random = new Random();
        int count;
        for (int i = 0; i < listCountTask.size(); i++) {
            count = listCountTask.get(i);
            if (count > 0) {
                allTask += count;
                this.listTaskByTopics.add(new QueueTaskByTopic((long) (i + 1), count, 0));
            }
        }
    }

    public Quest(Long topicId, int count, int step) {
        this.listTaskByTopics = new ArrayList<QueueTaskByTopic>();
        this.isTopicQuest = new ProgressDTO(topicId, null, step);
        int exp = (step / 3);
        allTask += count;
        this.listTaskByTopics.add(new QueueTaskByTopic(topicId, count, exp));
    }

    public Quest() {
        this.listTaskByTopics = new ArrayList<QueueTaskByTopic>();
        Random random = new Random();
        int count;
        for (int i = 0; i < 18; i++) {
            long topicId = i + 1;
            count = random.nextInt(2);
            if (count > 0) {
                allTask += count;
                this.listTaskByTopics.add(new QueueTaskByTopic(topicId, count, 0));
            }
        }
    }

    public QuestDTO getRandomTask() {
        Random random = new Random();
        int index = random.nextInt(listTaskByTopics.size());
        int exp = listTaskByTopics.get(index).getExp();
        if (exp == 0)
            exp = random.nextInt(3) + 1;
        return new QuestDTO(listTaskByTopics.get(index).getTopicId(), exp);
    }


    public Quest downCountTopic(Long topicId) {
        int index = 0;
        QueueTaskByTopic queueTaskByTopic = null;
        for (int i = 0; i < listTaskByTopics.size() & queueTaskByTopic == null; i++) {
            if (listTaskByTopics.get(i).getTopicId().equals(topicId)) {
                index = i;
                queueTaskByTopic = listTaskByTopics.get(i);
            }
        }
        if (queueTaskByTopic.getQueueSize() == 1)
            this.listTaskByTopics.remove(index);
        else {
            queueTaskByTopic.setQueueSize(queueTaskByTopic.getQueueSize() - 1);
            this.listTaskByTopics.set(index, queueTaskByTopic);
        }
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

    public List<QueueTaskByTopic> getListTaskByTopics() {
        return listTaskByTopics;
    }

    public void setListTaskByTopics(List<QueueTaskByTopic> listTaskByTopics) {
        this.listTaskByTopics = listTaskByTopics;
    }

    public ProgressDTO getIsTopicQuest() {
        return isTopicQuest;
    }

    public void setIsTopicQuest(ProgressDTO isTopicQuest) {
        this.isTopicQuest = isTopicQuest;
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
