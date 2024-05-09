package ru.lp.learnandplay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lp.learnandplay.model.Task;
import ru.lp.learnandplay.repository.TaskRepository;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getTask(long topic_id, int dif_level) {
        return taskRepository.findAllByIdTopicAndExp(topic_id, dif_level);
    }

}
