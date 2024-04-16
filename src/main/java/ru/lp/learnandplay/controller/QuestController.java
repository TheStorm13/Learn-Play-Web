package ru.lp.learnandplay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.lp.learnandplay.model.Task;

@RestController("/education/quest")
public class QuestController {

    @GetMapping("/historyQuest")
    public Task getHistoryQuest(@RequestBody String nameTopic, @RequestBody int step ){
        //todo
        return null;
    }
    //должен возвращать рандомную задачу на определенную тему определенного уровня
    @GetMapping("/newTask")
    public Task getNewTask(@RequestBody String nameTopic, @RequestBody int step ){
        //todo
        return null;
    }

    @PutMapping("/successTask")
    public boolean successTask(@RequestBody String idTask){
        //todo поменять статус у задания для конкретного пользователя
        return false;//todo
    }

    @PutMapping("/successQuest")
    public boolean successTask(@RequestBody String idTopic, @RequestBody int step){
        //todo поменять статус у квеста для конкретного пользователя
        return false;//todo
    }

}