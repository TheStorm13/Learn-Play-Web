package ru.lp.learnandplay.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.lp.learnandplay.dto.request.SuccessQuestDTO;
import ru.lp.learnandplay.dto.request.SuccessTaskDTO;
import ru.lp.learnandplay.model.Task;
import ru.lp.learnandplay.repository.TaskRepository;
import ru.lp.learnandplay.services.TaskServiceImpl;

import java.util.List;
import java.util.Random;

@RestController()
public class QuestController {
    @Autowired
    private TaskServiceImpl taskService;


    @GetMapping("/historyQuest/{topic_id}/{topic_step}")
    public Task getHistoryQuest(@PathVariable(name = "topic_id") Long topic_id, @PathVariable(name = "topic_step") int topic_step) {
        //todo
        return new Task();
    }

    //должен возвращать рандомную задачу на определенную тему определенного уровня
    @GetMapping("/getNewTask/{topic_id}/{dif_level}")
    public Task getNewTask(@PathVariable(name = "topic_id") Long topic_id,@PathVariable(name = "dif_level") int dif_level) {
       return taskService.getRandomTask(topic_id, dif_level);
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

        //todo поменять статус у квеста для конкретного пользователя

        return successQuestDTO.getTopicStep();//todo
    }

}