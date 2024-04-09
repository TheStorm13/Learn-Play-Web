package ru.lp.learnandplay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.lp.learnandplay.model.Task;
import ru.lp.learnandplay.model.Topic;

@RestController("/quest")
public class QuestController {

    //должен возвращать рандомную задачу на определенную тему определенного уровня
    @GetMapping("/newTask")
    public Task getNewTask(@RequestBody String nameTopic, @RequestBody int step ){
        //todo
        return null;
    }

    // нужен метод для возвращения квестовой истории

    // нужен пост запрос при успешном выполнении квеста

    // нужен пост запрос для успешного выполнения задания

}
