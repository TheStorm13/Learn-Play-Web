package ru.lp.learnandplay.dto.response;

import ru.lp.learnandplay.model.Progress;

public class ProgressDTO {
    private Long topicId;
    private String topicName;
    private Short step;

    public ProgressDTO(Long topicId, String topicName, Short step) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.step = step;
    }

    public ProgressDTO() {
    }

    public ProgressDTO(Progress progress) {
        System.out.println(progress.toString());
        this.topicId = progress.getTopic().getIdTopic();
        this.topicName = progress.getTopic().getNameTopic();
        this.step = progress.getStep();
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Short getStep() {
        return step;
    }

    public void setStep(Short step) {
        this.step = step;
    }
}
