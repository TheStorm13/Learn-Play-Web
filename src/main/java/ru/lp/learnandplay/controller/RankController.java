package ru.lp.learnandplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lp.learnandplay.dto.response.RankDTO;
import ru.lp.learnandplay.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/rank")
public class RankController {
    private int lengthList = 10;
    @Autowired
    private UserService userService;

    @GetMapping("/getRank")
    public RankDTO getRank() {
        return new RankDTO(userService.getUser());
    }

    @GetMapping("/getRankList")
    public List<RankDTO> getRankList() {
        return userService.getRankList();
    }
}
