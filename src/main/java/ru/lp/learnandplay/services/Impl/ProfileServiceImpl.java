package ru.lp.learnandplay.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lp.learnandplay.dto.response.ProfileDTO;
import ru.lp.learnandplay.model.Hero;
import ru.lp.learnandplay.model.User;
import ru.lp.learnandplay.repository.HeroRepository;
import ru.lp.learnandplay.repository.ProgressRepository;
import ru.lp.learnandplay.repository.UserRepository;
import ru.lp.learnandplay.services.ProfileService;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ProgressRepository progressRepository;
    @Autowired
    private HeroRepository heroRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public ProfileDTO profileInfo() {
        User user = userService.getUser();
        List<Object[]> achievement = progressRepository.findTopicsWithResolvedTasksByUser(user);
        return new ProfileDTO(user.getName(), (int) user.getExp(), user.getMultiplier(),user.getRankPlace(), achievement);
    }

    @Override
    public void changeName(String name) {
        User user = userService.getUser();
        user.setName(name);
        userRepository.save(user);
    }

    @Override
    public boolean changeHero(Long heroId) {
        Optional<Hero> hero = heroRepository.findById(heroId);
        if (hero.isEmpty()) return false;
        User user = userService.getUser();
        user.setHero(hero.get());
        return true;
    }
}
