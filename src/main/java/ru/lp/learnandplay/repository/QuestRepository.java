package ru.lp.learnandplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lp.learnandplay.model.Quest;
import ru.lp.learnandplay.model.User;

public interface QuestRepository extends JpaRepository<Quest, Long>  {
    Quest findByUser(User user);

}
