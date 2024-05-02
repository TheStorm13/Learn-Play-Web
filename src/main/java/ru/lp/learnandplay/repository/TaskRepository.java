package ru.lp.learnandplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.lp.learnandplay.model.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = """
            SELECT * FROM tasks t
            WHERE t.topic_id = :topicId
            AND t.exp= :exp
            """, nativeQuery = true)
    List<Task> findAllByIdTopicAndExp(Long topicId,int exp);
}
