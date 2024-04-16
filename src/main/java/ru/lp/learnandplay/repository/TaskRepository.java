package ru.lp.learnandplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.lp.learnandplay.model.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = """
            SELECT * FROM tasks t
            WHERE t.id_topic = :idTopic
            """, nativeQuery = true)
    List<Task> findAllByIdTopic(@Param("idTopic") Long idTopic);
}
