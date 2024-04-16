package ru.lp.learnandplay.controller;


import org.springframework.web.bind.annotation.*;
import ru.lp.learnandplay.dto.ResolvedTaskDTO;
import ru.lp.learnandplay.dto.TaskDTO;
import ru.lp.learnandplay.model.Task;
import ru.lp.learnandplay.repository.ResolvedTaskRepository;
import ru.lp.learnandplay.repository.TaskRepository;

import java.util.List;
import java.util.Map;

@RestController()
public class QuestController {
    private final TaskRepository taskRepository;
    private final ResolvedTaskRepository resolvedTaskRepository;

    public QuestController(TaskRepository taskRepository, ResolvedTaskRepository resolvedTaskRepository) {
        this.taskRepository = taskRepository;
        this.resolvedTaskRepository=resolvedTaskRepository;
    }

    @GetMapping("/historyQuest")
    public Task getHistoryQuest(@RequestParam String nameTopic, @RequestParam int step) {
        //todo
        return null;
    }

    //должен возвращать рандомную задачу на определенную тему определенного уровня
    @GetMapping("/getTask")
    public  List<Task> getNewTask(@RequestBody TaskDTO taskDTO) {
        List<Task> tasks = taskRepository.findAllByIdTopic(taskDTO.getIdTopic());
        return tasks;
    }


    @PutMapping("/successTask")
    public boolean successTask(@RequestBody ResolvedTaskDTO resolvedTaskDTO) {
        //todo поменять статус у задания для конкретного пользователя
        resolvedTaskRepository.updateCount(resolvedTaskDTO.getTaskId(), resolvedTaskDTO.getUserId());

        return false;
    }

    @PutMapping("/successQuest")
    public boolean successTask(@RequestBody String idTopic, @RequestBody int step) {
        //todo поменять статус у квеста для конкретного пользователя

        return false;//todo
    }

}