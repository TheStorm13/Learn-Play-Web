package ru.lp.learnandplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.lp.learnandplay.model.User;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query(value = "SELECT COUNT(*) + 1 FROM users WHERE exp > (SELECT exp FROM users WHERE user_id = ?1)", nativeQuery = true)
    int getUserRankByExp(Long userId);
}
