package ru.lp.learnandplay.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lp.learnandplay.dto.request.QuestDTO;
import ru.lp.learnandplay.dto.request.TopicQuestDTO;
import ru.lp.learnandplay.dto.request.UserQuestDTO;
import ru.lp.learnandplay.dto.response.ProgressDTO;
import ru.lp.learnandplay.model.Session.Quest;
import ru.lp.learnandplay.model.Task;
import ru.lp.learnandplay.services.QuestService;

@Service
public class QuestServiceImpl implements QuestService {
    @Autowired
    private TaskServiceImpl taskService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ProgressServiceImpl progressService;

    @Override
    public Quest createUserQuest(UserQuestDTO userQuestDTO) {
        return new Quest(userQuestDTO.getListTask());
    }

    @Override
    public Quest createTopicQuest(TopicQuestDTO topicQuestDTO) {
        Long topicId = topicQuestDTO.getTopicId();
        int step = topicQuestDTO.getStep();
        return new Quest(topicId, 10, step);
    }

    @Override
    public Task getTaskQuest(Quest quest) {
        QuestDTO questDTO = quest.getRandomTask();
        return taskService.getRandomTask(questDTO.getTopicId(), questDTO.getExp());
    }

    @Override
    public boolean successTaskInQuest(Quest quest, Long taskId) {
        if (quest==null)
            return false;
        Long topicId = taskService.getTopicId(taskId);
        quest.downCountTopic(topicId);
        quest.setSuccessTask(quest.getSuccessTask() + 1);
        userService.addExp(taskService.getExp(taskId));
        return true;
    }

    @Override
    public boolean failedTaskInQuest(Quest quest, Long taskId) {
        if (quest==null)
            return false;
        Long topicId = taskService.getTopicId(taskId);
        quest.downCountTopic(topicId);
        quest.setFailedTask(quest.getFailedTask() + 1);
        return true;
    }

    @Override
    public boolean isSuccessQuest(Quest quest) {
        return (quest.getSuccessTask() + quest.getFailedTask()) == quest.getAllTask() & (quest.getSuccessTask() >= quest.getFailedTask());
    }

    @Override
    public boolean successTopicQuest(Quest quest) {
        ProgressDTO progressDTO = quest.getIsTopicQuest();
        if (progressDTO != null) {
            progressService.incrementStep(progressDTO.getTopicId(), progressDTO.getStep());
            return true;
        }
        return false;
    }

}
