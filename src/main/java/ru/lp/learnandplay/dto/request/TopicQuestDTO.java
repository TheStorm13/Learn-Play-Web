package ru.lp.learnandplay.dto.request;

public class TopicQuestDTO {
    private Long topicId;
    private int step;

    public TopicQuestDTO() {
    }

    public TopicQuestDTO(Long topicId, int step) {
        this.topicId = topicId;
        this.step = step;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
