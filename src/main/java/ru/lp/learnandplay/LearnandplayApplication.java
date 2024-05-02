package ru.lp.learnandplay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class LearnandplayApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnandplayApplication.class, args);
    }


}
