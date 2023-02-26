package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.Lang;

public interface LangService extends IService<Lang> {
    Lang getLang(int id);

    String getLangServiceDemo(int id);

    Lang getLangByCache(int id);
}
