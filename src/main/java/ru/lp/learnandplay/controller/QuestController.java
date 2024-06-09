package ru.lp.learnandplay.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ru.lp.learnandplay.dto.request.TopicQuestDTO;
import ru.lp.learnandplay.dto.request.UserQuestDTO;
import ru.lp.learnandplay.model.Quest;
import ru.lp.learnandplay.model.TypeQuest;
import ru.lp.learnandplay.model.Task;
import ru.lp.learnandplay.services.Impl.QuestServiceImpl;
import ru.lp.learnandplay.services.Impl.TaskServiceImpl;

import java.util.List;

@RestController()
@RequestMapping("/quest")
public class QuestController {
    @Autowired
    private QuestServiceImpl questService;
    @Autowired
    private TaskServiceImpl taskService;


    @PostMapping("/startTopicQuest")
    public void startQuest(@RequestBody TopicQuestDTO topicQuestDTO) {
        questService.initTopicQuest(topicQuestDTO);
    }

    @PostMapping("/startUserQuest")
    public void startUserQuest(@RequestBody UserQuestDTO userQuestDTO) {
        questService.initUserQuest(userQuestDTO);
    }

    @PostMapping("/startDailyQuest")
    public void startDailyQuest() {
        questService.initDailyQuest();
    }

    @PostMapping("/startRandomQuest")
    public void startRandomQuest() {
        questService.initRandomQuest();
    }

    //должен возвращать рандомную задачу на определенную тему определенного уровня
    @GetMapping("/getNewTask")
    public Task getNewTask() {
        return questService.getTaskQuest();
    }

    //task successfully completed
    @PutMapping("/successTask/{taskId}")
    public boolean successTask(@PathVariable(name = "taskId") Long taskId) {
        return questService.successTaskInQuest( taskId);
    }

    //task unsuccessfully completed
    @PutMapping("/failedTask/{taskId}")
    public boolean failedTask(@PathVariable(name = "taskId") Long taskId) {
        questService.failedTaskInQuest( taskId);
        return true;
    }

    //quest success check
    @GetMapping("/successQuest")
    public boolean successQuest(SessionStatus status) {
        return questService.isSuccessQuest();
    }

    //end of quest check
    @GetMapping("/isEndQuest")
    public boolean isEndQuest() {
        return questService.isEndQuest();
    }

}