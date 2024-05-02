package ru.lp.learnandplay.dto.request;

public class SuccessQuestDTO {
    private Long TopicId;
    private int topicStep;

    public SuccessQuestDTO(Long topicId, int topicStep) {
        TopicId = topicId;
        this.topicStep = topicStep;
    }

    public Long getTopicId() {
        return TopicId;
    }

    public void setTopicId(Long topicId) {
        TopicId = topicId;
    }

    public int getTopicStep() {
        return topicStep;
    }

    public void setTopicStep(int topicStep) {
        this.topicStep = topicStep;
    }
}
