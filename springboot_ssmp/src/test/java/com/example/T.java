package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class T {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void test1() {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String name = ops.get("name");
        System.out.println("name: " + name);
    }
}
