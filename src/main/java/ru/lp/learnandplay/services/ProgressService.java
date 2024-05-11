package ru.lp.learnandplay.services;

import ru.lp.learnandplay.dto.response.ProgressDTO;
import ru.lp.learnandplay.model.Progress;

import java.util.List;

public interface ProgressService {
    public List<ProgressDTO> getListProgress();
}
