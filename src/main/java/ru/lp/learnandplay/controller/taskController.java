package ru.lp.learnandplay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lp.learnandplay.model.Task;

//@RestController
public class taskController {
    @GetMapping("/getTask")
    public Task getG() {
        return new Task(1l,1l,"What day is it?",null, "1",0, null);
    }
}
