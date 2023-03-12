package com.example.security.service;

import com.example.security.pojo.Result;
import com.example.security.pojo.User;

public interface UserService {
    Result login(User user);

    Result logout();
}
