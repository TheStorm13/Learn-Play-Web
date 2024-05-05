package ru.lp.learnandplay.services;

import ru.lp.learnandplay.dto.request.ProfileDTO;

public interface ProfileService {
    public ProfileDTO profileInfo();
    boolean changeHero(Long heroId);
    void changeName(String name);
}
