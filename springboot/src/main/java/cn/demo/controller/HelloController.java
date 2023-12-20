package cn.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;

@RestController
public class HelloController {
    @Autowired
    private ApplicationArguments args;

    @RequestMapping("/demo")
    public String demo() {
        return "demo";
    }

    @RequestMapping("/demo2")
    public String demo2() {
        if (true) {
            throw new RuntimeException("异常");
        }
        return "demo2";
    }

    @Scheduled(cron = "0/10 * * * * ?")
    public void demo3() {
        System.out.println(LocalDateTime.now());
    }


    @RequestMapping("/demo4")
    // 缓存存在，则使用缓存；不存在，则执行方法，并将结果塞入缓存
    @Cacheable(cacheNames = "demo", key = "#id")
    public String demo4(int id) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @RequestMapping("/demo5")
    // 保证方法被调用，又希望结果被缓存。与@Cacheable区别在于是否每次都调用方法，常用于更新
    @CachePut(cacheNames = "demo", key = "#id")
    public String demo5(int id) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @RequestMapping("/demo6")
    public String demo6(int id) {
        // 不能在当前类直接调用@Cacheable注解的方法,否则缓存无效
        return this.demo4(id);
    }
}