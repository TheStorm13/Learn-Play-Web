package ru.lp.learnandplay.services;


import ru.lp.learnandplay.model.Task;
import ru.lp.learnandplay.model.User;

import java.util.List;

public interface TaskService {
   public List<Task> getListTask(long topic_id, int dif_level);
   public Task getRandomTask(long topic_id, int dif_level);
   public void solvedTask(long taskId);
   public void addTask();
}
