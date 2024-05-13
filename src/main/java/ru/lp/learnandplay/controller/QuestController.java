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
import ru.lp.learnandplay.services.Impl.UserServiceImpl;

@RestController()
@RequestMapping("/quest")
public class QuestController {
    @Autowired
    private TaskServiceImpl taskService;
    @Autowired
    private QuestServiceImpl questService;
    @Autowired
    private ProgressServiceImpl progressService;
    @Autowired
    private UserServiceImpl userService;
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


    @GetMapping("/historyQuest")
    public Task getHistoryQuest(@PathVariable(name = "topicId") Long topicId, @PathVariable(name = "topicStep") int topicStep) {
        //todo {topicId}/{topicStep}
        //todo
        return new Task();
    }

    //должен возвращать рандомную задачу на определенную тему определенного уровня
    @GetMapping("/getNewTask")
    public Task getNewTask() {
        //todo
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

    //todo страничка с завершением квеста
    @GetMapping("/successQuest")
    public boolean successQuest() {
        //todo {topicId}/{topicStep}
        if (questService.isSuccessQuest(quest)) {
            progressService.incrementStep(topicId, topicStep);
            userService.addExp(2);
            return true;
        }
        return false;
    }

}