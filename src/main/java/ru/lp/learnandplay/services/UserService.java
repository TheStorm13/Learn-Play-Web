package ru.lp.learnandplay.services;

import ru.lp.learnandplay.model.User;

import java.util.Optional;

public interface UserService {
    public boolean addUser(User user);
    public User getUser();
}
