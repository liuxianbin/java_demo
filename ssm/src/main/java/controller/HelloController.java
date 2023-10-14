package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ICharsetService;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private ICharsetService charsetService;

    @RequestMapping("/demo")
    public String demo(@RequestParam(defaultValue = "0") int mockException) {
        if (mockException > 0) {
            throw new RuntimeException("mock");
        }
        return "index";
    }

    @ResponseBody
    @RequestMapping("/demo2")
    public String demo2(@RequestParam("name") String name) {
        System.out.println("name: " + name);
        return charsetService.getCharacterCollateName(name);
    }
}
