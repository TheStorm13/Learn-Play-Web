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
    @Autowired
    private ProgressServiceImpl progressService;

    //gives a list of where the user is on the education progress
    @GetMapping("/getListProgress")
    public List<ProgressDTO> getListProgress() {
        return progressService.getListProgress();
    }



}
