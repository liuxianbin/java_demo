package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 开启定时任务功能
@EnableCaching // 开启基于注解的缓存
public class SpringbootSsmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSsmpApplication.class, args);
    }

}
