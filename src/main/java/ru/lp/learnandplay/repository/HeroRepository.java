package ru.lp.learnandplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lp.learnandplay.model.Hero;

import java.util.Optional;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
    @Override
    Optional<Hero> findById(Long id);
}
