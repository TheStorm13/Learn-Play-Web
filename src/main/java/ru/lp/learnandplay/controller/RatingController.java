package ru.lp.learnandplay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.lp.learnandplay.dto.response.UserRatingDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RatingController {
    @GetMapping("/getListRating/{size_list}")
    public List<UserRatingDTO> getListRating(@PathVariable(name = "size_list") Long size_list) {
        List<UserRatingDTO> listUserRating=new ArrayList<UserRatingDTO>();
        //todo
        return listUserRating;
    }
    @GetMapping("/getMyRating")
    public UserRatingDTO getMyRating() {
        UserRatingDTO userRatingDTO=new UserRatingDTO();
        //todo
        return userRatingDTO;
    }
}
