package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;

@Controller("/user")
public class UserController {
    @ResponseBody
    @RequestMapping("/demo")
    public User demo() {
        User u = new User();
        u.setUsername("java");
        u.setAge(100);
        return u;
    }
}
