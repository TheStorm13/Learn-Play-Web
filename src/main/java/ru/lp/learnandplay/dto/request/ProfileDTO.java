package ru.lp.learnandplay.dto.request;

import java.util.List;

public class ProfileDTO {
    private String userName;
    private int exp;
    private float multiplier;
    private int top;
    private List<Object[]> achievement;

    public ProfileDTO(String userName, int exp, float multiplier, int top, List<Object[]> achievement) {
        this.userName = userName;
        this.exp = exp;
        this.multiplier = multiplier;
        this.top = top;
        this.achievement = achievement;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public float getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(float multiplier) {
        this.multiplier = multiplier;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public List<Object[]> getAchievement() {
        return achievement;
    }

    public void setAchievement(List<Object[]> achievement) {
        this.achievement = achievement;
    }
}
