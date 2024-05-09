package ru.lp.learnandplay.services;

import ru.lp.learnandplay.model.Task;

import java.util.List;

public interface TaskService {
    public List<Task> getTask(long topic_id, int dif_level) ;
}
