package ru.lp.learnandplay.dto;

public class TaskDTO {
    private Long idTopic;
    private int step;

    public TaskDTO(Long idTopic, int step) {
        this.idTopic = idTopic;
        this.step = step;
    }

    public Long getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(Long idTopic) {
        this.idTopic = idTopic;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
