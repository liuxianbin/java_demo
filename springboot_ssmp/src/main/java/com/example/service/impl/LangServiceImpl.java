package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.LangMapper;
import com.example.pojo.Lang;
import com.example.service.LangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LangServiceImpl extends ServiceImpl<LangMapper, Lang> implements LangService {
    @Autowired
    private LangMapper langMapper;

    @Override
    public Lang getLang(int id) {
        return langMapper.getLangById(id);
    }
}
