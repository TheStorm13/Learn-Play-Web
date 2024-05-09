package ru.lp.learnandplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.lp.learnandplay.model.ResolvedTask;


public interface ResolvedTaskRepository extends JpaRepository<ResolvedTask, Long> {
    @Modifying
    @Query(value = """
            UPDATE tasks t
            SET t.count= t.count+1
            WHERE t.task_id= :taskId
            """, nativeQuery = true)
    int updateTaskByIdTask(Long taskId);
}
