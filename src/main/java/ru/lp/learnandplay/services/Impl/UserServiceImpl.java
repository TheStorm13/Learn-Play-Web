package ru.lp.learnandplay.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.lp.learnandplay.dto.response.RankDTO;
import ru.lp.learnandplay.model.User;
import ru.lp.learnandplay.repository.ProgressRepository;
import ru.lp.learnandplay.repository.UserRepository;
import ru.lp.learnandplay.services.UserService;

import java.util.ArrayList;
import java.util.List;
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
        user.setPassword(encryptPassword(user.getPassword()));
        userRepository.save(user);
        user.setRankPlace((int) (long) user.getId());
        progressRepository.addProgressForUserWithDefaultValues(user);
        return true;
    }

    @Override
    public User getUser() {
        //todo брать юзера из сессии
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userRepository.findByEmail(authentication.getName());
        return user.get();
    }

    @Override
    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean changePassword(String oldPassword, String newPassword) {
        User user = getUser();
        String encryptedPassword1=user.getPassword();
        String encryptedPassword2 = encryptPassword(oldPassword);
        if (user.getPassword().equals(encryptPassword(oldPassword))) {
            user.setPassword(encryptPassword(newPassword));
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean changeEmail(String newEmail) {
        User user = getUser();
        user.setEmail(newEmail);
        userRepository.save(user);
        return true;

    }

    @Override
    public List<RankDTO> getRankList() {
         List<User> listUser=userRepository.findTop3ByOrderByRankPlaceDesc();
         List<RankDTO> listUserDTO=new ArrayList<RankDTO>();
         for (User user:listUser) {
             listUserDTO.add(new RankDTO(user));
         }
         return listUserDTO;
    }

    @Override
    public void addExp(int exp){
        User user = getUser();
        user.setExp(user.getExp()+exp);
        userRepository.save(user);
    }
}
