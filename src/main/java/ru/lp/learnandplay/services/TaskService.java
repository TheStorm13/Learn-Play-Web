package ru.lp.learnandplay.services;


import ru.lp.learnandplay.model.Task;

import java.util.List;

public interface TaskService {
    public List<Task> getListTask(Long topic_id, int dif_level);

    public List<Task> getListRandomTask(Long topic_id, int dif_level,int limit);

    public Task getRandomTask(Long topic_id, int dif_level);

    public int getExp(Long taskId);

    public void addTask();

    public Long getTopicId(Long taskId);
    public Task getTask(Long task_id);
}
