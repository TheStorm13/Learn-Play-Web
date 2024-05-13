package ru.lp.learnandplay.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.lp.learnandplay.model.Task;
import ru.lp.learnandplay.services.Impl.TaskServiceImpl;

@RestController()
//@RequestMapping("/quest")
public class QuestController {
    @Autowired
    private TaskServiceImpl taskService;


    @GetMapping("/historyQuest/{topicId}/{topicStep}")
    public Task getHistoryQuest(@PathVariable(name = "topicId") Long topicId, @PathVariable(name = "topicStep") int topicStep) {
        //todo
        return new Task();
    }

    //должен возвращать рандомную задачу на определенную тему определенного уровня
    @GetMapping("/getNewTask/{topicId}/{difLevel}")
    public Task getNewTask(@PathVariable(name = "topicId") long topicId,@PathVariable(name = "difLevel") int difLevel) {
       return taskService.getRandomTask((Long) topicId, difLevel);
    }

    @PutMapping("/successTask/{taskId}")
    public boolean successTask(@PathVariable(name = "taskId") Long taskId) {
        //получить пользователя
        //++count в ResolvedTasks конкретного задания и пользователя
        //todo поменять статус у задания для конкретного пользователя

        return false;
    }

    @PutMapping("/successQuest/{topicId}/{topicStep}")
    public int successQuest(@PathVariable(name = "topicId") Long topicId, @PathVariable(name = "topicStep") int topicStep) {

        //todo поменять статус у квеста для конкретного пользователя

        return 0;//todo
    }

}