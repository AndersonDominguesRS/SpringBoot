package com.example.springboot_tp3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringBootTp3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTp3Application.class, args);
    }

}
