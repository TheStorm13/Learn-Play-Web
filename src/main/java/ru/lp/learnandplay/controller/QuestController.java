package ru.lp.learnandplay.controller;


import org.springframework.web.bind.annotation.*;
import ru.lp.learnandplay.dto.TaskDTO;
import ru.lp.learnandplay.model.Task;
import ru.lp.learnandplay.repository.TaskRepository;

import java.util.List;
import java.util.Map;

@RestController()
public class QuestController {
    private final TaskRepository taskRepository;

    public QuestController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
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
    public boolean successTask(@RequestBody String idTask) {
        //todo поменять статус у задания для конкретного пользователя
        return false;//todo
    }

    @PutMapping("/successQuest")
    public boolean successTask(@RequestBody String idTopic, @RequestBody int step) {
        //todo поменять статус у квеста для конкретного пользователя
        return false;//todo
    }

}