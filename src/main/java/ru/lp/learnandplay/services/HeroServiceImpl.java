package ru.lp.learnandplay.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lp.learnandplay.model.Hero;
import ru.lp.learnandplay.repository.HeroesRepository;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroesRepository heroRepository;

    @Override
    public Hero saveHero(Hero hero) {
        return heroRepository.save(hero);
    }

    @Override
    public Hero getHeroById(Long id) {
        return heroRepository.findById(id).orElse(null);
    }

    // Другие методы, если необходимо
}