package service.impl;

import org.springframework.stereotype.Service;
import service.UserService;

@Service
public class UserServiceImpl2 implements UserService {
    @Override
    public void doWork() {
        System.out.println("do work2......");
    }

    @Override
    public void doDbWork() {

    }
}
