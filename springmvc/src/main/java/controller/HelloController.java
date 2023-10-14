package controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pojo.User;

import java.util.Date;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/demo")
    public String demo(@RequestParam("username") String uname, int age) {
        return uname + "," + age;
    }

    @RequestMapping("/demo2/{name}")
    // @PathVariable绑定url中的占位符
    public String demo2(@PathVariable("name") String name) {
        return name;
    }

    @RequestMapping("/demo3")
    public User demo3(User u) {
        return u;
    }

    @RequestMapping("/demo4")
    // @RequestBody绑定json请求
    public User demo4(@RequestBody User u) {
        return u;
    }

    @RequestMapping("/demo5")
    public Date demo5(@DateTimeFormat(pattern = "yyyy-MM-dd") Date d) {
        System.out.println(d);
        return d;
    }
}
