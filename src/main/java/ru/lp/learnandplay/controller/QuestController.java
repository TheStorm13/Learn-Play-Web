package ru.lp.learnandplay.controller;


import org.springframework.web.bind.annotation.*;
import ru.lp.learnandplay.dto.request.SuccessQuestDTO;
import ru.lp.learnandplay.dto.request.SuccessTaskDTO;
import ru.lp.learnandplay.model.Task;
import ru.lp.learnandplay.model.User;
import ru.lp.learnandplay.repository.TaskRepository;
import ru.lp.learnandplay.repository.UserRepository;

import java.util.List;
import java.util.Random;

@RestController()
public class QuestController {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    Random r = new Random();

    public QuestController(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/historyQuest/{topic_id}/{topic_step}")
    public Task getHistoryQuest(@PathVariable(name = "topic_id") Long topic_id, @PathVariable(name = "topic_step") int topic_step) {
        //todo
        return new Task();
    }

    //должен возвращать рандомную задачу на определенную тему определенного уровня
    @GetMapping("/getNewTask/{topic_id}/{dif_level}")
    public Task getNewTask(@PathVariable(name = "topic_id") Long topic_id,@PathVariable(name = "dif_level") int dif_level) {
        //todo diff_level
        List<Task> tasks = taskRepository.findAllByIdTopicAndExp(topic_id,dif_level);
        return tasks.get(r.nextInt(tasks.size()));
    }

    @PutMapping("/successTask/{task_id}")
    public boolean successTask(@RequestBody SuccessTaskDTO successTaskDTO) {
        //получить пользователя
        //++count в ResolvedTasks конкретного задания и пользователя
        //todo поменять статус у задания для конкретного пользователя

        return false;
    }

    @PutMapping("/successQuest")
    public int successQuest(@RequestBody SuccessQuestDTO successQuestDTO) {
        User user = new User();
        user.setId(1l);
        //userRepository.save(user);

        //todo поменять статус у квеста для конкретного пользователя

        return successQuestDTO.getTopicStep();//todo
    }

}