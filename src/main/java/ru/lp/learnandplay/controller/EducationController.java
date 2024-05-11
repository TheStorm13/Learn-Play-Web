package ru.lp.learnandplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lp.learnandplay.dto.response.ProgressDTO;
import ru.lp.learnandplay.model.Progress;
import ru.lp.learnandplay.services.Impl.ProgressServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/education")
public class EducationController {
    //todo получение на каком шаге находятся пользователь
@Autowired
private ProgressServiceImpl progressService;
    @GetMapping("/getListProgress")
    public List<ProgressDTO> getListProgress(){
        return progressService.getListProgress();
    }

    @GetMapping("/startQuest/{topicId}/{topicStep}")
    public String getQuest(@PathVariable(name = "topicId") Long topic_id, @PathVariable(name = "topicStep") int topicStep){
        //todo отправляет html для начала задания
        //cookie
        return null;
    }

    //возвращает страничку справочника


}
