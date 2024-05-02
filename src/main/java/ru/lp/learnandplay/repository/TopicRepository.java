package ru.lp.learnandplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lp.learnandplay.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
