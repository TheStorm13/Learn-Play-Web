package ru.lp.learnandplay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lp.learnandplay.dto.response.RankDTO;

import java.util.List;

@RestController
@RequestMapping("/rank")
public class RankController {
    private int lengthList=10;

    @GetMapping("/getRankList")
    public List<RankDTO> getRankList(){

    }
}
