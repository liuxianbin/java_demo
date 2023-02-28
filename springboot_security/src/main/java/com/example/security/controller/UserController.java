package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @ResponseBody
    @RequestMapping("/demo")
    public String demo() {
        return "demo";
    }
}
