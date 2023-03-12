package com.example.security.controller;

import com.example.security.pojo.Result;
import com.example.security.pojo.User;
import com.example.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/demo")
    public String demo() {
        return "demo";
    }

    @RequestMapping("/login")
    public Result login(@RequestBody User user) {
        return userService.login(user);
    }

    @RequestMapping("/logout")
    public Result logout() {
        return userService.logout();
    }
}
