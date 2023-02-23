package com.example.controller;

import com.example.setting.My;
import com.example.setting.MyTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
@Import(MyTool.class)
@Slf4j
public class UserController {
    @Value("${my.tel}")
    private String tel;

    @Autowired
    // 封装全部数据到Environment对象
    private Environment environment;

    @Autowired
    private My my;

    @RequestMapping("/demo")
    @ResponseBody
    public String demo() {
        System.out.println("tel: " + tel);
        System.out.println("environment tel: " + environment.getProperty("my.tel"));
        System.out.println("my:" + my);
        return "demo";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/demo2")
    @ResponseBody
    public String demo2() {
        if (true) {
            throw new RuntimeException("Mock RuntimeException");
        }
        return "demo2";
    }

    @RequestMapping("/demo3")
    @ResponseBody
    public String demo3() {
        // 使用@Slf4j注解
        // 等效于 private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class)
        log.info("slf4j...");
        return "@Slf4j";
    }
}
