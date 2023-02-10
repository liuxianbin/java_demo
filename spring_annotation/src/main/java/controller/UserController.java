package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import service.UserService;

@Controller
public class UserController {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    public void doWork() {
        userService.doWork();
    }

    public void doDbWork() {
        userService.doDbWork();
    }

}
