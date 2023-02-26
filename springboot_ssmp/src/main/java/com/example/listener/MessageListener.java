package com.example.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    @JmsListener(destination = "demo")
    public void receive(String id) {
        System.out.println("监听==>已完成" + id);
    }

}
