package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;

@Controller
public class UserController {
    @RequestMapping("/demo")
    public String demo() {
        return "demo";
    }

    @RequestMapping("/json")
    @ResponseBody
    public User json(User u) {
        System.out.println(u);
        return u;
    }
}
