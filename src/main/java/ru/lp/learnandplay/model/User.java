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


}
