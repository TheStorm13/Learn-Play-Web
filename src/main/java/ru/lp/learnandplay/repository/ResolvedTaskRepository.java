package ru.lp.learnandplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lp.learnandplay.model.ResolvedTask;
import ru.lp.learnandplay.model.Task;
import ru.lp.learnandplay.model.User;

public interface ResolvedTaskRepository extends JpaRepository<ResolvedTask, User> {
    //todo прибавить +1 к count при успешном выполнеии таски у опреденного пользователя
}
