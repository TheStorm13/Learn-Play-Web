package ru.lp.learnandplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lp.learnandplay.model.Task;
import ru.lp.learnandplay.model.User;

@Repository
public interface TasksRepository extends JpaRepository<Task, Long> {
}
