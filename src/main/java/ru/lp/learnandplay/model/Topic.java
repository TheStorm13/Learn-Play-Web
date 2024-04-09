package ru.lp.learnandplay.model;

public class Topic {
    private int idTopic;
    private String nameTopic;

    public Topic(int idTopic, String nameTopic) {
        this.idTopic = idTopic;
        this.nameTopic = nameTopic;
    }

    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }

    public String getNameTopic() {
        return nameTopic;
    }

    public void setNameTopic(String nameTopic) {
        this.nameTopic = nameTopic;
    }
}
