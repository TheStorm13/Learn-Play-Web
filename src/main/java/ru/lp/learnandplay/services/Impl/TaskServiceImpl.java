package ru.lp.learnandplay.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lp.learnandplay.model.ResolvedTask;
import ru.lp.learnandplay.model.Task;
import ru.lp.learnandplay.repository.ResolvedTaskRepository;
import ru.lp.learnandplay.repository.TaskRepository;
import ru.lp.learnandplay.services.TaskService;

import java.util.List;


@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ResolvedTaskRepository resolvedTaskRepository;
    @Autowired
    private UserServiceImpl userService;

    @Override
    public List<Task> getListTask(Long topic_id, int dif_level) {
//todo

        return null;
    }

    @Override
    public Task getRandomTask(Long topic_id, int dif_level) {
//todo

        return null;
    }

    @Override
    public void successTask(Long taskId) {

        //resolvedTaskRepository.updateTaskByIdTask(taskId);
    }

    @Override
    public void addTask() {
        ResolvedTask resolvedTask = new ResolvedTask();
        resolvedTask.setUser(userService.getUser());
        resolvedTaskRepository.save(resolvedTask);
    }

    @Override
    public Long getTopicId(Long taskId) {
        System.out.println(taskRepository.findTopicIdByTaskId(taskId));
        return null;
    }

}
