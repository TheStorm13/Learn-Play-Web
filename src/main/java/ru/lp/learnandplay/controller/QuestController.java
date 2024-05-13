package ru.lp.learnandplay.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.lp.learnandplay.dto.request.TopicQuestDTO;
import ru.lp.learnandplay.dto.request.UserQuestDTO;
import ru.lp.learnandplay.model.Session.Quest;
import ru.lp.learnandplay.model.Task;
import ru.lp.learnandplay.services.Impl.ProgressServiceImpl;
import ru.lp.learnandplay.services.Impl.QuestServiceImpl;
import ru.lp.learnandplay.services.Impl.TaskServiceImpl;

@RestController()
//@RequestMapping("/quest")
public class QuestController {
    @Autowired
    private TaskServiceImpl taskService;
    @Autowired
    private QuestServiceImpl questService;
    @Autowired
    private ProgressServiceImpl progressService;
    @Autowired
    Quest quest;

    @PostMapping("/startQuest")
    public void startQuest(@RequestBody TopicQuestDTO topicQuestDTO) {
        quest = questService.createTopicQuest(topicQuestDTO);
    }

    @PostMapping("/startUserQuest")
    public void startUserQuest(@RequestBody UserQuestDTO userQuestDTO) {
        quest = questService.createUserQuest(userQuestDTO);
    }

    @PostMapping("/startDailyQuest")
    public Quest startDailyQuest() {
        quest = new Quest();
        return quest;
    }

    @GetMapping("/getQuest")
    public Quest getQuest() {
        return quest;
    }


    @GetMapping("/historyQuest/{topicId}/{topicStep}")
    public Task getHistoryQuest(@PathVariable(name = "topicId") Long topicId, @PathVariable(name = "topicStep") int topicStep) {
        //todo
        return new Task();
    }

    //должен возвращать рандомную задачу на определенную тему определенного уровня
    @GetMapping("/getNewTask/{topicId}/{difLevel}")
    public Task getNewTask(@PathVariable(name = "topicId") Long topicId, @PathVariable(name = "difLevel") int difLevel) {
        return taskService.getRandomTask(topicId, difLevel);
    }

    @PutMapping("/successTask/{taskId}")
    public boolean successTask(@PathVariable(name = "taskId") Long taskId) {
        questService.successTaskInQuest(quest, taskId);
        //получить пользователя
        //++count в ResolvedTasks конкретного задания и пользователя
        //todo поменять статус у задания для конкретного пользователя

        return false;
    }

    @PutMapping("/failedTask/{taskId}")
    public boolean failedTask(@PathVariable(name = "taskId") Long taskId) {
        questService.failedTaskInQuest(quest, taskId);
        return false;
    }

    @PutMapping("/successQuest/{topicId}/{topicStep}")
    public boolean successQuest(@PathVariable(name = "topicId") Long topicId, @PathVariable(name = "topicStep") int topicStep) {
        //if (questService.isSuccessQuest(quest)) {
            //todo добавить проверку на последнее доступное задание
            progressService.incrementCount(topicId);
            return true;
        //}

        //return false;
    }

}