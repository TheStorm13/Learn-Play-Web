package ru.lp.learnandplay.controller;

import org.springframework.web.bind.annotation.*;
import ru.lp.learnandplay.model.Task;

import java.util.Random;

@RestController
public class taskController {

    Random r = new Random();
    @CrossOrigin
    @GetMapping("/getTask")
    public Task getG() {
        return new Task(1l,1l, Integer.toString(r.nextInt(6)),null, "1",0, null);
    }
    @PutMapping("/successTask")
    public Long addUser(@RequestBody Long idTask) {
        return idTask;
    }
}

