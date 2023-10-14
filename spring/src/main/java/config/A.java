package config;

import bean.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
@Data
public class A {
    @Autowired
    private User user;
}
