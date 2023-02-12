package controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.User;

import java.util.Date;

@Controller
public class UserController {
    @RequestMapping("/demo")
    @ResponseBody
    public String demo() {
        return "demo";
    }

    @RequestMapping("/demo2")
    @ResponseBody
    public String demo2(@RequestParam("uname") String username) {
        System.out.println("username: " + username);
        return username;
    }

    @RequestMapping("/demo3")
    @ResponseBody
    public User demo3(User u) {
        System.out.println("user: " + u);
        return u;
    }

    @RequestMapping("/demo4")
    @ResponseBody
    // @RequestBody绑定json请求
    public User demo4(@RequestBody User u) {
        System.out.println("user: " + u);
        return u;
    }

    @RequestMapping("/demo5/{info}")
    @ResponseBody
    // @PathVariable绑定url中的占位符
    public String demo5(@PathVariable("info") String info) {
        System.out.println("info: " + info);
        return info;
    }

    @RequestMapping("/demo6")
    @ResponseBody
    public Date demo6(@DateTimeFormat(pattern = "yyyy-MM-dd") Date d) {
        System.out.println("date: " + d);
        return d;
    }

}