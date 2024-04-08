package ru.lp.learnandplay.controller;

import com.fasterxml.jackson.databind.JsonSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.lp.learnandplay.model.test;

@RestController
public class testController {
    @GetMapping("/getTask")
    public test getG() {
        return new test(1l,1l,"What day is it?", "1",0, null);
    }
}
