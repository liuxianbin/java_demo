package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.pojo.Lang;
import com.example.service.LangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lang")
public class LangController {
    @Autowired
    private LangService langService;

    @RequestMapping("/detail/{id}")
    public Lang getLang(@PathVariable int id) {
        return langService.getLang(id);
    }


    @RequestMapping("/demo")
    public String demo() {
        IPage<Lang> page = new Page<>(1, 5);
        IPage<Lang> page1 = langService.page(page);
        System.out.println(page1);
        System.out.println(page1.getPages());
        System.out.println(page1.getCurrent());
        System.out.println(page1.getSize());
        System.out.println(page1.getTotal());
        System.out.println(page1.getRecords());
        return "";
    }
}
