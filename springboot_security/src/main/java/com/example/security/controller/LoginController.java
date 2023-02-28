package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("doSuccess")
    public String success() {
        return "redirect:/home.html";
    }

    @RequestMapping("doError")
    public String error() {
        return "redirect:/error.html";
    }
}
