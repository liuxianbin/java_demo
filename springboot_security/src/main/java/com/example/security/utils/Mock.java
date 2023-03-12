package com.example.security.utils;

import com.example.security.pojo.LoginUser;
import com.example.security.pojo.User;

public class Mock {
    public static LoginUser getMockLoginUser(Integer uid) {
        String password = "";
        return new LoginUser(new User(1, "admin", password));
    }
}
