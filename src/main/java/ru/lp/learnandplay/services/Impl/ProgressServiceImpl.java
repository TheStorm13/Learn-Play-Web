package ru.lp.learnandplay.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lp.learnandplay.dto.response.ProgressDTO;
import ru.lp.learnandplay.model.Progress;
import ru.lp.learnandplay.model.User;
import ru.lp.learnandplay.repository.ProgressRepository;
import ru.lp.learnandplay.repository.TopicRepository;
import ru.lp.learnandplay.services.ProgressService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgressServiceImpl implements ProgressService {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ProgressRepository progressRepository;
    @Autowired
    private TopicRepository topicRepository;

    @Override
    public List<ProgressDTO> getListProgress() {
        User user = userService.getUser();
        List<ProgressDTO> listProgressDTO = new ArrayList<>();
        List<Progress> listProgress = progressRepository.findByUserOrderById(user);
        //todo успростить, может упростить запрос sql
        for (Progress progress : listProgress) {
            listProgressDTO.add(new ProgressDTO(progress));
        }
        return listProgressDTO;
    }

    @Override
    public void incrementStep(Long topicId, int topicStep) {
        User user = userService.getUser();
        Progress progress = progressRepository.findByUserIdAndTopicId(user.getId(), topicId);
        if (progress.getStep() == topicStep) {
            progress.setStep((short) (progress.getStep()+1));
            progressRepository.save(progress);
            userService.addExp(2);
        }
    }

}
