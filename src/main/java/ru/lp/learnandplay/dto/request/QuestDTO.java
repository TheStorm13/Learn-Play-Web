package ru.lp.learnandplay.dto.request;

public class QuestDTO {
    private Long topicId;
    private int exp;

    public QuestDTO(Long topicId, int exp) {
        this.topicId = topicId;
        this.exp = exp;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
