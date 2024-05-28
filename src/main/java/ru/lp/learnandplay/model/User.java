package ru.lp.learnandplay.model;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "name_user", length = 30)
    private String name;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "exp")
    private float exp=0;
    @Column(name = "rank_place")
    private int rankPlace;
    @Column(name = "is_daily")
    private boolean dailyQuest = false;
    @Column(name = "multiplier")
    private float multiplier = 1;
    @ManyToOne
    @JoinColumn(name = "hero_id")
    private Hero hero;
    @Column(name = "role")
    private String role;
    @Column(name = "send_daily_notice")
    private boolean sendDailyNotice=true;

    public User() {
    }

    public User(Long id, String name, String email, String password, float exp, int rankPlace, boolean dailyQuest, float multiplier, Hero hero, String role, boolean sendDailyNotice) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.exp = exp;
        this.rankPlace = rankPlace;
        this.dailyQuest = dailyQuest;
        this.multiplier = multiplier;
        this.hero = hero;
        this.role = role;
        this.sendDailyNotice = sendDailyNotice;
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

    public float getExp() {
        return exp;
    }

    public void setExp(float exp) {
        this.exp = exp;
    }

    public int getRankPlace() {
        return rankPlace;
    }

    public void setRankPlace(int rankPlace) {
        this.rankPlace = rankPlace;
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

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isSendDailyNotice() {
        return sendDailyNotice;
    }

    public void setSendDailyNotice(boolean sendDailyNotice) {
        this.sendDailyNotice = sendDailyNotice;
    }
}
