package ru.lp.learnandplay.controller;


import org.springframework.web.bind.annotation.*;
import ru.lp.learnandplay.model.Task;
import ru.lp.learnandplay.repository.TaskRepository;

import java.util.List;
import java.util.Random;

@RestController()
public class QuestController {
    private final TaskRepository taskRepository;
    Random r = new Random();

    public QuestController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/historyQuest")
    public Task getHistoryQuest(@RequestParam String nameTopic, @RequestParam int step) {
        //todo
        return null;
    }

    //должен возвращать рандомную задачу на определенную тему определенного уровня
    @GetMapping("/getNewTask")
    public Task getNewTask() {
        List<Task> tasks = taskRepository.findAllByIdTopic(1l);
        return tasks.get(r.nextInt(tasks.size()));
    }

    @PutMapping("/successTask")
    public boolean successTask() {
        //todo поменять статус у задания для конкретного пользователя

        return false;
    }

    @PutMapping("/successQuest")
    public boolean successTask(@RequestBody String idTopic, @RequestBody int step) {
        //todo поменять статус у квеста для конкретного пользователя

        return false;//todo
    }

}