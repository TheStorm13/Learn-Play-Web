package ru.lp.learnandplay.services;

import ru.lp.learnandplay.dto.response.ProgressDTO;

import java.util.List;

public interface ProgressService {
    public List<ProgressDTO> getListProgress();

    public void incrementStep(Long topicId, int topicStep);
}
