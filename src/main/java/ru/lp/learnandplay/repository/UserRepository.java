package ru.lp.learnandplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.lp.learnandplay.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query(value = "SELECT COUNT(*) + 1 FROM users WHERE exp > (SELECT exp FROM users WHERE user_id = ?1)", nativeQuery = true)
    int getUserRankByExp(Long userId);

    //todo добавить тригер на место в рейтинге и заменить exp на rank_place
    @Query(value = """
            SELECT * FROM users 
            ORDER BY exp DESC
            LIMIT 10
            """, nativeQuery = true)
    List<User> findTop3ByOrderByRankPlaceDesc();
}
