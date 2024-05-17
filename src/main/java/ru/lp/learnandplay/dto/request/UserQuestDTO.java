package ru.lp.learnandplay.dto.request;

import java.util.List;

public class UserQuestDTO {
    private List<Integer> listTask;

    public UserQuestDTO() {
    }

    public UserQuestDTO(List<Integer> listTask) {
        this.listTask = listTask;
    }

    public List<Integer> getListTask() {
        return listTask;
    }

    public void setListTask(List<Integer> listTask) {
        this.listTask = listTask;
    }
}
