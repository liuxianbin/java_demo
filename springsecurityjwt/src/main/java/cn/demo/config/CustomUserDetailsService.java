package cn.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
// 自定义密码存储 UserDetailsService
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("------数据库验证账户1------");
        if (!"admin".equals(username)) {
            throw new RuntimeException("用户不存在");
        }
        int uid = 1001;
        String password = passwordEncoder.encode("123");
        List<String> authorities = List.of("book:read", "book:write");
        System.out.println("------数据库验证账户2------");

        return CustomUserDetails.withBuilder()
                .withUsername(username)
                .withPassword(password)
                .withAuthorities(authorities)
                .withUid(uid)
                .build();
    }
}