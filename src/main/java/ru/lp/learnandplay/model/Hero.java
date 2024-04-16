package ru.lp.learnandplay.model;

import jakarta.persistence.*;

@Entity
@Table(name = "heroes")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hero_id")
    private Long idHero;
    @Column(name = "name_hero")
    private String nameHero;
    @Column(name = "image")
    private String image;

    public Hero() {
    }

    public Hero(String nameHero, String image) {
        this.nameHero = nameHero;
        this.image = image;
    }

    public Long getIdHero() {
        return idHero;
    }

    public void setIdHero(Long idHero) {
        this.idHero = idHero;
    }

    public String getNameHero() {
        return nameHero;
    }

    public void setNameHero(String nameHero) {
        this.nameHero = nameHero;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
