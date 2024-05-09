package ru.lp.learnandplay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.lp.learnandplay.model.User;
import ru.lp.learnandplay.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private HeroServiceImpl heroService;

    public UserServiceImpl(UserRepository repository) {
        this.userRepository = repository;
    }

    @Override
    public boolean addUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) == null)
            return false;
        user.setMultiplier(1);
        user.setExp(0);
        user.setDailyQuest(false);
        user.setRole("ROLE_USER");
        user.setHero(heroService.getHeroById(1L));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    @Override
    public Optional<User> getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userRepository.findByEmail(authentication.getName());
        return user;
    }
}
