package com.example.controller;

import com.example.analyse.Analyse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/analyse")
public class AnalyseController {

    @Autowired
    private Analyse analyse;

    @RequestMapping("/demo")
    @ResponseBody
    public String demo() {
        analyse.print2();
        return "demo";
    }
}
