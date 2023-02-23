package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("m_lang")
public class Lang {
    private Integer id;
    private String name;
    private String remark;
    private Integer state;
}
