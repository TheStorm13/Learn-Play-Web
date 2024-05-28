package ru.lp.learnandplay.model.Session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public enum TypeQuest {
    Topic,
    User,
    Daily,
    Random,
    Boss
}
