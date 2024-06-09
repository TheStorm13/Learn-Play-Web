package ru.lp.learnandplay.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lp.learnandplay.model.Task;
import ru.lp.learnandplay.repository.TaskRepository;
import ru.lp.learnandplay.services.TaskService;

import java.util.List;


@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserServiceImpl userService;

    @Override
    public List<Task> getListTask(Long topic_id, int dif_level) {
//todo

        return null;
    }

    @Override
    public List<Task> getListRandomTask(Long topic_id, int dif_level, int limit) {
        return taskRepository.findRandomTaskByTopicAndExpLimit10(topic_id, dif_level, limit);
    }

    @Override
    public Task getRandomTask(Long topic_id, int dif_level) {
        return taskRepository.findRandomTaskByTopicAndExpLimit1(topic_id, dif_level);
    }
    @Override
    public Task getTask(Long task_id) {
        return taskRepository.findById(task_id).get();
    }

    @Override
    public int getExp(Long taskId) {
        return taskRepository.findById(taskId).get().getExp();
    }


    @Override
    public Long getTopicId(Long taskId) {
        return taskRepository.findTopicIdByTaskId(taskId);
    }

}
