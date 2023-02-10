package pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
@Data
public class User {
    @JsonProperty("uname")
    private String username;
    @JsonIgnore
    private int age;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;
}
