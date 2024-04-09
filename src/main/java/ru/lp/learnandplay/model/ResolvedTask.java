package ru.lp.learnandplay.model;

public class ResolvedTask {
    private int idUser;
    private int idTask;
    private int count;

    public ResolvedTask(int idUser, int idTask, int count) {
        this.idUser = idUser;
        this.idTask = idTask;
        this.count = count;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
