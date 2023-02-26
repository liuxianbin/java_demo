package com.example.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Demo {
    @Scheduled(cron = "0/10 * * * * ?")
    public void test1(){
        log.info("task do...");
    }
}
