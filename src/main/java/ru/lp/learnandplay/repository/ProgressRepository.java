package ru.lp.learnandplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.lp.learnandplay.model.Progress;
import ru.lp.learnandplay.model.Topic;
import ru.lp.learnandplay.model.User;

import java.util.List;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
    @Query("SELECT t.nameTopic, t.countTask, p.count " +
            "FROM Progress p " +
            "JOIN p.topic t " +
            "WHERE p.user = :user " +
            "GROUP BY t.nameTopic, p.count, t.countTask")
    List<Object[]> findTopicsWithResolvedTasksByUser(@Param("user") User user);

    @Transactional
    @Modifying
    @Query("INSERT INTO Progress (user, topic, step, count) " +
            "SELECT :user, t, 1, 0 FROM Topic t")
    void addProgressForUserWithDefaultValues(@Param("user") User user);

@Query(value= """
SELECT * FROM Progress p WHERE p.user = :userId AND p.topic.topic_id = :topicId
""",nativeQuery = true)
    Progress findByUserIdAndTopicId(User userId, Long topicId);
    List<Progress> findByUserOrderById(User user);
}
