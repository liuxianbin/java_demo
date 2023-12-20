package cn.demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class ErrController implements ErrorController {

    @RequestMapping("/error")
    public String doError(){
        return "404...";
    }
}
