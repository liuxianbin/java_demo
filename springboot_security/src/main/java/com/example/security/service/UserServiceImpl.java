package com.example.security.service;

import com.example.security.pojo.LoginUser;
import com.example.security.pojo.Result;
import com.example.security.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Result login(User user) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authentication);
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }
        LoginUser u = (LoginUser) authenticate.getPrincipal();
        return new Result(200, "ok", "token:" + u.getUser().getId());
    }

    @Override
    public Result logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser u = (LoginUser) authentication.getPrincipal();
        return new Result(200, "ok", "clear ok: " + u.getUser().getId());
    }
}
