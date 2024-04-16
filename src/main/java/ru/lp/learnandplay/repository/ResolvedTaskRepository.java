package ru.lp.learnandplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.lp.learnandplay.model.ResolvedTask;
import ru.lp.learnandplay.model.Task;

import java.util.List;

  /*
public interface ResolvedTaskRepository extends JpaRepository<ResolvedTask, Long> {

    @Query(value = """ 
            UPDATE resolved_task set count=:1
            WHERE user_id=:userId AND task_id=:taskId
            """, nativeQuery = true)
    void updateCount(@Param("taskId") Long taskId, @Param("userId") Long userId);


}
*/