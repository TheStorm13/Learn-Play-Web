package ru.lp.learnandplay.model;

public class ResolvedTask {
    private Long idUser;
    private Long idTask;
    private int count;

    public ResolvedTask(Long idUser, Long idTask, int count) {
        this.idUser = idUser;
        this.idTask = idTask;
        this.count = count;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
