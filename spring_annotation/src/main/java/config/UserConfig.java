package config;

import org.springframework.context.annotation.Bean;
import pojo.User;

//@Configuration //配置项如果不用于被扫描可以省略
public class UserConfig {
    @Bean
    public User user() {
        User u = new User();
        u.setUsername("tony");
        return u;
    }
}

