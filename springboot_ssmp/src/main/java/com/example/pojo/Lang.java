package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("m_lang")
public class Lang implements Serializable {
    private Integer id;
    private String name;
    private String remark;
    private Integer state;
}
