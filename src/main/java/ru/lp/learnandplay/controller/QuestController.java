package ru.lp.learnandplay.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.lp.learnandplay.dto.request.SuccessQuestDTO;
import ru.lp.learnandplay.dto.request.SuccessTaskDTO;
import ru.lp.learnandplay.model.Task;
import ru.lp.learnandplay.model.User;
import ru.lp.learnandplay.repository.TaskRepository;
import ru.lp.learnandplay.repository.UserRepository;
import ru.lp.learnandplay.services.TaskServiceImpl;
import ru.lp.learnandplay.services.UserServiceImpl;

import java.util.List;
import java.util.Random;

@RestController()
public class QuestController {
    private final UserServiceImpl userServiceImpl;
    private final TaskServiceImpl taskServiceImpl;
    Random r = new Random();

    @Autowired
    public QuestController(UserServiceImpl userServiceImpl, TaskServiceImpl taskServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.taskServiceImpl = taskServiceImpl;
    }

    @GetMapping("/historyQuest/{topic_id}/{topic_step}")
    public Task getHistoryQuest(@PathVariable(name = "topic_id") Long topic_id, @PathVariable(name = "topic_step") int topic_step) {
        //todo
        return new Task();
    }

    //должен возвращать рандомную задачу на определенную тему определенного уровня
    @GetMapping("/getNewTask/{topic_id}/{dif_level}")
    public Task getNewTask(@PathVariable(name = "topic_id") Long topic_id,@PathVariable(name = "dif_level") int dif_level) {
        //todo diff_level
        List<Task> tasks = taskServiceImpl.getTask(topic_id,dif_level);
        return tasks.get(r.nextInt(tasks.size()));
    }

    @PutMapping("/successTask")
    public boolean successTask(@RequestBody SuccessTaskDTO successTaskDTO) {
        //получить пользователя
        //++count в ResolvedTasks конкретного задания и пользователя
        //todo поменять статус у задания для конкретного пользователя

        return false;
    }

    @PutMapping("/successQuest")
    public int successQuest(@RequestBody SuccessQuestDTO successQuestDTO) {
        User user = userServiceImpl.getUser();


        //todo поменять статус у квеста для конкретного пользователя

        return successQuestDTO.getTopicStep();//todo
    }

}