package ru.lp.learnandplay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lp.learnandplay.model.ResolvedTask;
import ru.lp.learnandplay.model.Task;
import ru.lp.learnandplay.model.User;
import ru.lp.learnandplay.repository.ResolvedTaskRepository;
import ru.lp.learnandplay.repository.TaskRepository;
import ru.lp.learnandplay.repository.UserRepository;

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
    public List<Task> getListTask(long topic_id, int dif_level) {
//todo

        return null;
    }

    @Override
    public Task getRandomTask(long topic_id, int dif_level) {
//todo

        return null;
    }

    @Override
    public void solvedTask(long taskId) {
        resolvedTaskRepository.updateTaskByIdTask(taskId);
    }

    @Override
    public void addTask() {
        ResolvedTask resolvedTask = new ResolvedTask();
        resolvedTask.setUser(userService.getUser());
        resolvedTaskRepository.save(resolvedTask);
    }

}
