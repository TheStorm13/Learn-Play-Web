package ru.lp.learnandplay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.lp.learnandplay.model.Task;

import java.util.List;

@Controller("/education")
public class EducationController {
    //todo получение на каком шаге находятся пользователь





    @GetMapping("/startQuest")
    public String getQuest(@RequestBody int id_topic, @RequestBody int step){
        //todo отправляет html для начала задания
        return null;
    }

    //возвращает страничку справочника
    @GetMapping("/tutorial{id_topic}")
    public String getPageTutorial(@PathVariable int id_topic){
        //todo
        return null;
    }

}
