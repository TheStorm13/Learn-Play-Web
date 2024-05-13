package ru.lp.learnandplay.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long idTask;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
    @Column(name = "question", columnDefinition = "text")
    private String question;
    @Column(name = "add_text", columnDefinition = "text")
    private String addText;
    @Column(name = "answer")
    private String answer;
    @Column(name = "exp")
    private int exp;
    @Column(name = "image")
    private String image;

    public Task() {
    }

    public Task(Long id, Topic topic, String question, String addText, String answer, int exp, String image) {
        this.idTask = id;
        this.topic = topic;
        this.question = question;
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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getQuotation() {
        return question;
    }

    public void setQuotation(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
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
