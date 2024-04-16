package ru.lp.learnandplay.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @Column(name = "id_task")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTask;
    @Column(name = "id_topic")
    private Long idTopic;
    private String quotation;
    private String addText;
    private String answer;
    private double exp;
    private String image;

    public Task() {
    }

    public Task(Long id, Long idTopic, String quotation, String addText, String answer, double exp, String image) {
        this.idTask = id;
        this.idTopic = idTopic;
        this.quotation = quotation;
        this.addText = addText;
        this.answer = answer;
        this.exp = exp;
        this.image = image;
    }

    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }

    public Long getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(Long idTopic) {
        this.idTopic = idTopic;
    }

    public String getQuotation() {
        return quotation;
    }

    public void setQuotation(String quotation) {
        this.quotation = quotation;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddText() {
        return addText;
    }

    public void setAddText(String addText) {
        this.addText = addText;
    }
}
