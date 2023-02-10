package pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Lang implements Serializable {
    private Integer id;
    private String name;
    private String remark;
    private Integer state;
    private List<User> users;
}