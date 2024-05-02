package ru.lp.learnandplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.lp.learnandplay.model.Topic;
import ru.lp.learnandplay.model.User;

import java.util.List;

@Repository
public interface TopicsRepository extends JpaRepository<Topic, Long> {
    List<Topic> findAll();

    @Query("SELECT t.nameTopic, t.countTask, p.count " +
            "FROM Progress p " +
            "JOIN p.topic t " +
            "WHERE p.user = :user " +
            "GROUP BY t.nameTopic, p.count, t.countTask")
    List<Object[]> findTopicsWithResolvedTasksByUser(@Param("user") User user);
}
