package ru.lp.learnandplay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lp.learnandplay.dto.request.ProfileDTO;
import ru.lp.learnandplay.model.Hero;
import ru.lp.learnandplay.model.User;
import ru.lp.learnandplay.repository.HeroesRepository;
import ru.lp.learnandplay.repository.TopicsRepository;
import ru.lp.learnandplay.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private TopicsRepository topicsRepository;
    @Autowired
    private HeroesRepository heroesRepository;
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public ProfileDTO profileInfo() {
        User user = userService.getUser();
        List<Object[]> achievement = topicsRepository.findTopicsWithResolvedTasksByUser(user);
        int top = usersRepository.getUserRankByExp(user.getId());
        return new ProfileDTO(user.getName(), user.getExp(), user.getMultiplier(),top, achievement);
    }

    public boolean changeHero(Long heroId) {
        Optional<Hero> hero = heroesRepository.findById(heroId);
        if (hero.isEmpty()) return false;
        User user = userService.getUser();
        user.setHero(hero.get());
        return true;
    }

    public void changeName(String name) {
        User user = userService.getUser();
        user.setName(name);
    }
}
