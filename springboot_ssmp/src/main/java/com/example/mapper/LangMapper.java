package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Lang;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LangMapper extends BaseMapper<Lang> {
    Lang getLangById(int id);
}
