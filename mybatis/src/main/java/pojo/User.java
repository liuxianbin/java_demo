package pojo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private Date birth;
    private double salary;
    private double sign1;
    private double sign2;
    private LocalDateTime createTime;
    private int state;
    private Lang lang;
}