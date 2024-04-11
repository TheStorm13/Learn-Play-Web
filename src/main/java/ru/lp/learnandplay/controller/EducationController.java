package ru.lp.learnandplay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.lp.learnandplay.model.Task;

import java.util.Collections;
import java.util.List;

@Controller("/education")
public class EducationController {

    @GetMapping("/")
    public String getEntryPage() {
        return "education";
    }

    //методы для получения страниц на панели навигации - вынести в отдельный контроллер

    // возвращает квест на roadmap'e
    @GetMapping("/topic{id_topic}step{step}")
    public String getQuest(){
        //todo
        return null;
    }

    //возвращает страничку справочника
    @GetMapping("/tutorial{id_topic}")
    public String getPageTutorial(int id_topic){
        //todo
        return null;
    }


    @GetMapping("/tasks/{userId}")
    public List<Task> transactions(String userId) {

        // find tasks by user
        // List<Transaction> = dao.findByUserId(userId);

        List<Task> tasks = Collections.emptyList();
        return tasks;
    }
}
