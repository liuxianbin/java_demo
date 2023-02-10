package pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("m_user")
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private Date birth;
    private Double salary;
    private Double sign1;
    private Double sign2;
    private LocalDateTime createTime;
    private Integer state;
    private Lang lang;
}