package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.UserService;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void doWork() {
        System.out.println("do work...");
    }

    @Override
    @Transactional(noRollbackForClassName = "java.lang.ArithmeticException")
    public void doDbWork() {
        System.out.println("start do db work...");
        int num = jdbcTemplate.update("update users set create_time=? where id=1", LocalDateTime.now());
        System.out.println("update ok:" + num);
        System.out.println("do db work end...");
        System.out.println(10 / 0);
    }
}
