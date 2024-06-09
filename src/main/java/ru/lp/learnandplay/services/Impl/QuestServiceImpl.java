package ru.lp.learnandplay.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lp.learnandplay.model.User;
import ru.lp.learnandplay.dto.request.TopicQuestDTO;
import ru.lp.learnandplay.dto.request.UserQuestDTO;
import ru.lp.learnandplay.dto.response.ProgressDTO;
import ru.lp.learnandplay.model.Progress;
import ru.lp.learnandplay.model.Quest;
import ru.lp.learnandplay.model.TypeQuest;
import ru.lp.learnandplay.model.Task;
import ru.lp.learnandplay.repository.ProgressRepository;
import ru.lp.learnandplay.repository.QuestRepository;
import ru.lp.learnandplay.services.QuestService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuestServiceImpl implements QuestService {
    @Autowired
    private TaskServiceImpl taskService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ProgressServiceImpl progressService;
    @Autowired
    private ProgressRepository progressRepository;
    @Autowired
    private QuestRepository questRepository;

    @Override
    public Quest getQuest() {
        return questRepository.findByUser(userService.getUser());
    }

    @Override
    public List<Task> getListTaskQuest() {
        return List.of();
    }

    @Override
    public void isUnique() {
        Quest quest = getQuest();
        if (quest != null) {
            questRepository.delete(quest);
        }
    }

    @Override
    public void initTopicQuest(TopicQuestDTO topicQuestDTO) {
        isUnique();
        Quest quest = new Quest();
        quest.setUser(userService.getUser());
        quest.setTypeQuest(TypeQuest.Topic);
        quest.setTopicId(topicQuestDTO.getTopicId());
        quest.setTopicStep(topicQuestDTO.getStep());
        quest.setAllTask(10);
        List<Long> listTaskId = new ArrayList<>();
        List<Task> listTask = taskService.getListRandomTask(topicQuestDTO.getTopicId(), (topicQuestDTO.getStep() / 3) + 1, 10);
        for (Task task : listTask) {
            listTaskId.add(task.getIdTask());
        }

        quest.setListTask(listTaskId);
        questRepository.save(quest);
    }

    @Override
    public void initUserQuest(UserQuestDTO userQuestDTO) {
        isUnique();
        Quest quest = new Quest();
        quest.setUser(userService.getUser());
        quest.setTypeQuest(TypeQuest.User);
        List<Long> listTaskId = new ArrayList<>();
        List<Task> listTask;
        List<Integer> listCountTopic = new ArrayList<>(userQuestDTO.getListTask());
        Random random = new Random();
        for (int i = 0; i < listCountTopic.size(); i++) {
            if(listCountTopic.get(i)>0){
                listTask = taskService.getListRandomTask((long) (i+1), random.nextInt(3) + 1, listCountTopic.get(i));
                for (Task task : listTask) {
                    listTaskId.add(task.getIdTask());
                }
            }

        }
        quest.setListTask(listTaskId);
        quest.setAllTask(listTaskId.size());
        questRepository.save(quest);
        System.out.println("init"+quest.getAllTask()+" "+quest.getSuccessTask()+" "+quest.getFailedTask());

    }

    @Override
    public void initRandomQuest() {
        isUnique();
        Quest quest = new Quest();
        quest.setUser(userService.getUser());
        quest.setTypeQuest(TypeQuest.Random);
        quest.setAllTask(1);
        Random random = new Random();
        List<Long> listTaskId = new ArrayList<>();
        listTaskId.add(taskService.getRandomTask((long) (random.nextInt(18) + 1), random.nextInt(3) + 1).getIdTask());
        quest.setListTask(listTaskId);
        questRepository.save(quest);
    }

    @Override
    public void initDailyQuest() {
        isUnique();
        Quest quest = new Quest();
        quest.setUser(userService.getUser());
        quest.setTypeQuest(TypeQuest.Daily);
        quest.setAllTask(10);
        Random random = new Random();
        List<Long> listTaskId = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            if (random.nextBoolean()) {
                listTaskId.add(taskService.getRandomTask((long) (i), random.nextInt(3) + 1).getIdTask());
            }
        }
        quest.setListTask(listTaskId);
        quest.setAllTask(listTaskId.size());
        questRepository.save(quest);
        System.out.println(quest.getAllTask()+" "+quest.getSuccessTask()+" "+quest.getFailedTask());


    }

    @Override
    public Task getTaskQuest() {
        Random random = new Random();
        Quest quest = getQuest();
        List<Long> listTaskQuest = quest.getListTask();
        int index = random.nextInt(listTaskQuest.size());
        return taskService.getTask(listTaskQuest.get(index));
    }

    @Override
    public boolean successTaskInQuest(Long taskId) {
        Quest quest = getQuest();
        if (quest == null)
            return false;
        Long topicId = taskService.getTopicId(taskId);
        List<Long> listTasks = quest.getListTask();
        listTasks.remove(taskId);
        quest.setListTask(listTasks);
        quest.setSuccessTask(quest.getSuccessTask() + 1);
        questRepository.save(quest);
        userService.addExp(taskService.getExp(taskId));

        Progress progress = progressRepository.findByUserIdAndTopicId(userService.getUser().getId(), topicId);
        progress.setCount(progress.getCount() + 1);
        progressRepository.save(progress);
        System.out.println(quest.getAllTask()+" "+quest.getSuccessTask()+" "+quest.getFailedTask());
        return true;
    }

    @Override
    public boolean failedTaskInQuest(Long taskId) {
        Quest quest = getQuest();
        if (quest == null)
            return false;
        List<Long> listTasks = quest.getListTask();
        listTasks.remove(taskId);
        quest.setListTask(listTasks);
        quest.setFailedTask(quest.getFailedTask() + 1);
        questRepository.save(quest);
        System.out.println(quest.getAllTask()+" "+quest.getSuccessTask()+" "+quest.getFailedTask());
        return true;
    }

    @Override
    public boolean isEndQuest() {
        Quest quest = getQuest();
        System.out.println(quest.getAllTask()+" "+quest.getSuccessTask()+" "+quest.getFailedTask());
        return (quest.getSuccessTask() + quest.getFailedTask()) == quest.getAllTask();
    }

    @Override
    public boolean isSuccessQuest() {
        Quest quest = getQuest();
        if (quest == null)
            return false;

        if (quest.getSuccessTask() >= quest.getFailedTask()) {
            if (quest.getTypeQuest() == TypeQuest.Topic) {
                progressService.incrementStep(quest.getTopicId(), quest.getTopicStep());
            }
            if (quest.getTypeQuest() == TypeQuest.Daily) {
                userService.upMultiplier();
                userService.switchDaily();
            }
            userService.addExp(2);
            System.out.println(quest.getAllTask()+" "+quest.getSuccessTask()+" "+quest.getFailedTask());
            return true;
        }
        return false;

    }

}
