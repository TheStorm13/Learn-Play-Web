package ru.lp.learnandplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lp.learnandplay.model.Hero;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
}
