package cn.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
// 自定义密码存储 UserDetailsService
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("数据库验证账户信息...");
        if (!"admin".equals(username)) {
            throw new RuntimeException("用户不存在");
        }
        String password = passwordEncoder.encode("123");
        return User
                .withUsername(username)
                .password(password)
                .authorities("book:delete", "book:write")
                .build();
    }
}