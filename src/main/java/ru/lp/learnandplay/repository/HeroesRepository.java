package ru.lp.learnandplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lp.learnandplay.model.Hero;
import ru.lp.learnandplay.model.User;

@Repository
public interface HeroesRepository extends JpaRepository<Hero, Long> {
}
