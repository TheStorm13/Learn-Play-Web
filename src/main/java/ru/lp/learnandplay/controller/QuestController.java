package ru.lp.learnandplay.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ru.lp.learnandplay.dto.request.TopicQuestDTO;
import ru.lp.learnandplay.dto.request.UserQuestDTO;
import ru.lp.learnandplay.model.Session.Quest;
import ru.lp.learnandplay.model.Session.TypeQuest;
import ru.lp.learnandplay.model.Task;
import ru.lp.learnandplay.services.Impl.QuestServiceImpl;

@RestController()
@RequestMapping("/quest")

public class QuestController {
    @Autowired
    private QuestServiceImpl questService;
    @Autowired
    Quest quest;

    @PostMapping("/startTopicQuest")
    public void startQuest(@RequestBody TopicQuestDTO topicQuestDTO) {
        quest = questService.createTopicQuest(topicQuestDTO);
        quest.setTypeQuest(TypeQuest.Topic);
    }

    @PostMapping("/startUserQuest")
    public void startUserQuest(@RequestBody UserQuestDTO userQuestDTO) {
        quest = questService.createUserQuest(userQuestDTO);
        quest.setTypeQuest(TypeQuest.User);
    }

    @PostMapping("/startDailyQuest")
    public Quest startDailyQuest() {
        quest = new Quest();
        quest.setTypeQuest(TypeQuest.Daily);
        return quest;
    }

    @PostMapping("/startRandomQuest")
    public Quest startRandomQuest() {
        quest = new Quest();
        quest.setAllTask(1);
        quest.setTypeQuest(TypeQuest.Random);
        return quest;
    }

    @GetMapping("/getQuest")
    public Quest getQuest() {
        return quest;
    }


    @GetMapping("/historyQuest")
    public Task getHistoryQuest() {
        //todo
        return null;
    }

    //должен возвращать рандомную задачу на определенную тему определенного уровня
    @GetMapping("/getNewTask")
    public Task getNewTask() {
        return questService.getTaskQuest(quest);
    }

    @PutMapping("/successTask/{taskId}")
    public boolean successTask(@PathVariable(name = "taskId") Long taskId) {
        return questService.successTaskInQuest(quest, taskId);
        //получить пользователя
        //++count в ResolvedTasks конкретного задания и пользователя
        //todo поменять статус у задания для конкретного пользователя
    }

    @PutMapping("/failedTask/{taskId}")
    public boolean failedTask(@PathVariable(name = "taskId") Long taskId) {
        questService.failedTaskInQuest(quest, taskId);
        return true;
    }

    @GetMapping("/successQuest")
    public boolean successQuest(SessionStatus status) {
        //todo не работает очищение объекта
        boolean isSucsessQuest = questService.isSuccessQuest(quest);
        quest = null;
        return isSucsessQuest;
    }

    @GetMapping("/isEndQuest")
    public boolean isEndQuest() {
        return questService.isEndQuest(quest);
    }

}