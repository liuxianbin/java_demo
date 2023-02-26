package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsMessagingTemplate;

@SpringBootTest
public class T2 {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Test
    public void test1() {
        System.out.println("待发送");
        jmsMessagingTemplate.convertAndSend("demo", "1001");
    }

    @Test
    public void test2() {
        String id = jmsMessagingTemplate.receiveAndConvert("demo", String.class);
        System.out.println("已完成" + id);
    }
}
