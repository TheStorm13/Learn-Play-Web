package ru.lp.learnandplay.dto.response;

import ru.lp.learnandplay.model.User;

public class RankDTO {

    private String userName;
    private int rankPlace;
    private int exp;

    public RankDTO(String userName, int rank_place, int exp) {
        this.userName = userName;
        this.rankPlace = rank_place;
        this.exp = exp;
    }

    public RankDTO() {
    }
    public RankDTO(User user) {
        this.userName=user.getName();
        this.rankPlace=user.getRankPlace();
        this.exp= (int) user.getExp();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRank_place() {
        return rankPlace;
    }

    public void setRank_place(int rank_place) {
        this.rankPlace = rank_place;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
