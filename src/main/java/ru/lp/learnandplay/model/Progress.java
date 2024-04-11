package ru.lp.learnandplay.model;

public class Progress {
    private Long idUser;
    private Long idTopic;
    private int step=1;

    public Progress(Long idUser, Long idTopic, int step) {
        this.idUser = idUser;
        this.idTopic = idTopic;
        this.step = step;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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
