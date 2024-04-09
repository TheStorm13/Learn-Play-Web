package ru.lp.learnandplay.model;

public class Hero {
    private int idHero;
    private int idUser;
    private String image;

    public Hero(int idHero, int idUser, String image) {
        this.idHero = idHero;
        this.idUser = idUser;
        this.image = image;
    }

    public int getIdHero() {
        return idHero;
    }

    public void setIdHero(int idHero) {
        this.idHero = idHero;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
