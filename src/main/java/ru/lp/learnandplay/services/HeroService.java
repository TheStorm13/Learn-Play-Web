package ru.lp.learnandplay.services;

import ru.lp.learnandplay.model.Hero;

public interface HeroService {
    public Hero saveHero(Hero hero);

    public Hero getHeroById(Long id);
}
