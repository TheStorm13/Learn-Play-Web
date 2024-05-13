package ru.lp.learnandplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.lp.learnandplay.model.Task;
import ru.lp.learnandplay.model.Topic;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = """
            SELECT * FROM tasks t
            WHERE t.topic_id = :topicId
            """, nativeQuery = true)
    List<Task> findAllByIdTopic(Long topicId);
    @Query(value = """
            SELECT topic_id FROM tasks t
            WHERE t.task_id = :taskId
            """, nativeQuery = true)
    Long findTopicIdByTaskId(Long taskId);

}
