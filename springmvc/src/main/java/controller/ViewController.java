package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/view")
public class ViewController {
    @RequestMapping("/demo")
    public String demo() {
        return "index";
    }
}
