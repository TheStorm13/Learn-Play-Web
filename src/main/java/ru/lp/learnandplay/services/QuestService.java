package ru.lp.learnandplay.services;

import ru.lp.learnandplay.dto.request.TopicQuestDTO;
import ru.lp.learnandplay.dto.request.UserQuestDTO;
import ru.lp.learnandplay.model.Session.Quest;
import ru.lp.learnandplay.model.Task;

public interface QuestService {
    public Quest createUserQuest(UserQuestDTO userQuestDTO);

    public Quest createTopicQuest(TopicQuestDTO topicQuestDTO);

    public Task getTaskQuest(Quest quest);

    public Quest successTaskInQuest(Quest quest, Long taskId);

    public Quest failedTaskInQuest(Quest quest, Long taskId);

    public boolean isSuccessQuest(Quest quest);

    public boolean successTopicQuest(Quest quest);
}
