package ru.lp.learnandplay.services;

import ru.lp.learnandplay.dto.request.TopicQuestDTO;
import ru.lp.learnandplay.dto.request.UserQuestDTO;
import ru.lp.learnandplay.model.Quest;
import ru.lp.learnandplay.model.Task;

import java.util.List;

public interface QuestService {
    public Quest getQuest();

    public void initTopicQuest(TopicQuestDTO topicQuestDTO);

    public void initUserQuest(UserQuestDTO userQuestDTO);

    public void isUnique();

    public void initRandomQuest();

    public void initDailyQuest();

    public List<Task> getListTaskQuest();

    public boolean successTaskInQuest(Long taskId);

    public boolean failedTaskInQuest(Long taskId);

    public boolean isEndQuest();

    public boolean isSuccessQuest();

    public Task getTaskQuest();
}
