package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.LangMapper;
import com.example.pojo.Lang;
import com.example.service.LangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class LangServiceImpl extends ServiceImpl<LangMapper, Lang> implements LangService {
    @Autowired
    private LangMapper langMapper;

    @Override
    // 保证方法被调用，又希望结果被缓存。与@Cacheable区别在于是否每次都调用方法，常用于更新
    @CachePut(value = "lang-detail", key = "#id")
    public Lang getLang(int id) {
        return langMapper.getLangById(id);
    }

    @Override
    // 缓存存在，则使用缓存；不存在，则执行方法，并将结果塞入缓存
    @Cacheable(value = "lang-detail", key = "#id")
    public Lang getLangByCache(int id) {
        return null;
    }

    @Override
    public String getLangServiceDemo(int id) {
        Lang l = this.getLangByCache(id); // 不能在当前类直接调用@Cacheable注解的方法
        System.out.println("service==Lang==>" + l);
        return "getLangServiceDemo...";
    }
}
