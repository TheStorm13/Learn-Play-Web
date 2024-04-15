package ru.lp.learnandplay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.lp.learnandplay.model.Task;

import java.util.Collections;
import java.util.List;

@Controller
public class EducationController {

    //методы для получения страниц на панели навигации - вынести в отдельный контроллер
    // - вынесла в NavigationController

    // возвращает квест на roadmap'e
    @GetMapping("/education/topic{id_topic}step{step}")
    public String getQuest(@PathVariable int id_topic, @PathVariable int step){
        //todo
        return null;
    }

    //возвращает страничку справочника
    @GetMapping("/education/tutorial{id_topic}")
    public String getPageTutorial(@PathVariable int id_topic){
        //todo
        return null;
    }


    @GetMapping("/education/tasks/{userId}")
    public List<Task> transactions(@PathVariable String userId) {

        // find tasks by user
        // List<Transaction> = dao.findByUserId(userId);

        List<Task> tasks = Collections.emptyList();
        return tasks;
    }
}
