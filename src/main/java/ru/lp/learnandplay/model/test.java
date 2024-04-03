package ru.lp.learnandplay.model;

public class test {
    private Long id;

    private String name;

    //Конструкторы и getter, setter нужны, чтобы обернуть класс в json
    public test(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
