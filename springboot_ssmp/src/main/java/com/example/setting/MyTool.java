package com.example.setting;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

@EnableConfigurationProperties(My.class) //bean名称为my-com.example.setting.My
//@Import(My.class) //可以不使用该注解,使用@EnableConfigurationProperties(My.class)按需注册bean
public class MyTool {
    public MyTool(My m) {
        System.out.println("my init..." + m);
    }
}