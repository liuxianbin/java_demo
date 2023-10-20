package cn.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}