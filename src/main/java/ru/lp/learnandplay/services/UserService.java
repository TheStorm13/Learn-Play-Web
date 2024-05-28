package ru.lp.learnandplay.services;

import ru.lp.learnandplay.dto.response.RankDTO;
import ru.lp.learnandplay.model.User;

import java.util.List;

public interface UserService {
    public boolean addUser(User user);

    public User getUser();

    public String encryptPassword(String password);

    public boolean changePassword(String oldPassword, String newPassword);

    public boolean changeEmail(String newEmail);

    public List<RankDTO> getRankList();

    public void addExp(int exp);

    public void updateRankPlace(User user);

    public void upMultiplier();

    public void switchDaily();

    public void switchDailyNotice(boolean active);

}
