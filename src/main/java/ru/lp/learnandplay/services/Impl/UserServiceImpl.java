package ru.lp.learnandplay.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.lp.learnandplay.model.User;
import ru.lp.learnandplay.repository.ProgressRepository;
import ru.lp.learnandplay.repository.UserRepository;
import ru.lp.learnandplay.services.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private HeroServiceImpl heroService;
    @Autowired
    private ProgressRepository progressRepository;

    @Override
    public boolean addUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent())
            return false;
        user.setMultiplier(1);
        user.setExp(0);
        user.setDailyQuest(false);
        user.setRole("ROLE_USER");
        user.setHero(heroService.getHeroById(1L));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        user.setRankPlace((int) (long) user.getId());
        progressRepository.addProgressForUserWithDefaultValues(user);
        return true;
    }

    @Override
    public User getUser() {
        //todo ускорить
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userRepository.findByEmail(authentication.getName());
        return user.get();
    }
}
