package ru.lp.learnandplay.services.Impl;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class DatabaseInitializationService {
   /*
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //Раскомментировать этот метод перед инциализацией бд(update -> create)
    /*@PostConstruct
    public void initDatabase() {
        long count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM heroes", Long.class);
        if (count == 0) insertHeroRecord();
        count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM topics", Long.class);
        if (count == 0) executeSqlScript("topic.sql");
        count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM tasks", Long.class);
        if (count == 0) executeSqlScript("task.sql");
    }

    private void executeSqlScript(String fileName) {
        try {
            File file = ResourceUtils.getFile("classpath:" + fileName);
            String sql = new String(Files.readAllBytes(file.toPath()));
            jdbcTemplate.execute(sql);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertHeroRecord() {
        String sql = "INSERT INTO heroes (hero_id, image, name_hero) VALUES (?, ?, ?)";
        Long heroId = 1l;
        String imagePath = "path/to/image.jpg";
        String heroName = "Superman";
        jdbcTemplate.update(sql, heroId, imagePath, heroName);
    }

    */
}
