package com.example.backupdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BackupdbApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackupdbApplication.class, args);
    }

}
