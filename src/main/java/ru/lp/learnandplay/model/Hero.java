package ru.lp.learnandplay.model;

import jakarta.persistence.*;

@Entity
@Table(name = "heroes")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHero;
    private String image;

    public Hero() {
    }

    public Hero(int idUser, String image) {
        this.image = image;
    }

    public Long getIdHero() {
        return idHero;
    }

    public void setIdHero(Long idHero) {
        this.idHero = idHero;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
