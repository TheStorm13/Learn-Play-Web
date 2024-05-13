package ru.lp.learnandplay.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lp.learnandplay.dto.request.TopicQuestDTO;
import ru.lp.learnandplay.dto.request.UserQuestDTO;
import ru.lp.learnandplay.model.Session.Quest;
import ru.lp.learnandplay.services.QuestService;

@Service
public class QuestServiceImpl implements QuestService {
    @Autowired
    private TaskServiceImpl taskService;

    @Override
    public Quest createUserQuest(UserQuestDTO userQuestDTO) {
        return new Quest(userQuestDTO.getListTask());
    }

    @Override
    public Quest createTopicQuest(TopicQuestDTO topicQuestDTO) {
        Long topicId = topicQuestDTO.getTopicId();
        int exp = topicQuestDTO.getStep() / 3;
        return new Quest(topicId, 10, exp);
    }

    @Override
    public Quest successTaskInQuest(Quest quest, Long taskId) {
        Long topicId = taskService.getTopicId(taskId);
        quest.downCountTopic(topicId);
        quest.setSuccessTask(quest.getSuccessTask() + 1);
        return quest;
    }

    @Override
    public Quest failedTaskInQuest(Quest quest, Long taskId) {
        Long topicId = taskService.getTopicId(taskId);
        quest.downCountTopic(topicId);
        quest.setFailedTask(quest.getFailedTask() + 1);
        return quest;
    }

    @Override
    public boolean isSuccessQuest(Quest quest) {
        return (quest.getSuccessTask() + quest.getFailedTask()) == quest.getAllTask();
    }
}
