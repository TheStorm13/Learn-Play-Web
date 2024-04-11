package ru.lp.learnandplay.model;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private int exp;
    private boolean dailyQuest;
    private float multiplier;
    private int idFrame;

    public User() {
    }

    public User(String name, String email, String password, int exp, boolean dailyQuest, float multiplier, int idFrame) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.exp = exp;
        this.dailyQuest = dailyQuest;
        this.multiplier = multiplier;
        this.idFrame = idFrame;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public boolean isDailyQuest() {
        return dailyQuest;
    }

    public void setDailyQuest(boolean dailyQuest) {
        this.dailyQuest = dailyQuest;
    }

    public float getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(float multiplier) {
        this.multiplier = multiplier;
    }

    public int getIdFrame() {
        return idFrame;
    }

    public void setIdFrame(int idFrame) {
        this.idFrame = idFrame;
    }
}
