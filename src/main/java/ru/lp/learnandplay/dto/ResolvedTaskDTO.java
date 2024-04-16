package ru.lp.learnandplay.dto;

public class ResolvedTaskDTO {
    private Long userId;

    private Long taskId;

    public ResolvedTaskDTO(Long userId, Long taskId) {
        this.userId = userId;
        this.taskId = taskId;
    }


    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
