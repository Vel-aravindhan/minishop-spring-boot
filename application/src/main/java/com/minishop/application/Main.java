package com.minishop.application;


import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.minishop")
@EntityScan(basePackages = "com.minishop.shared.entity")
@EnableJpaRepositories(basePackages = "com.minishop.shared.repository")
public class Main {

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }
}
