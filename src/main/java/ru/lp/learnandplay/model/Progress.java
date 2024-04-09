package ru.lp.learnandplay.model;

public class Progress {
    private int idUser;
    private int idTopic;
    private int step;

    public Progress(int idUser, int idTopic, int step) {
        this.idUser = idUser;
        this.idTopic = idTopic;
        this.step = step;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
