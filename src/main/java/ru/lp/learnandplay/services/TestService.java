package ru.lp.learnandplay.services;


import ru.lp.learnandplay.model.User;

public interface TestService {
    User login(User loginRequest);
}
