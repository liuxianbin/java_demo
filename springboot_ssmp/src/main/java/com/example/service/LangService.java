package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.Lang;

public interface LangService extends IService<Lang> {
    Lang getLang(int id);
}
