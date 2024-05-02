package ru.lp.learnandplay.dto.request;

public class SuccessTaskDTO {
    private Long taskId;

    public SuccessTaskDTO(Long taskId) {
        this.taskId = taskId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}
