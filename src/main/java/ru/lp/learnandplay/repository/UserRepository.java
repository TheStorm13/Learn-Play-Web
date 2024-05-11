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
    @Query(value = """
            SELECT * FROM users u 
            ORDER BY rank_place DESC  3
            """,nativeQuery = true)
    List<User> findTo();
}
