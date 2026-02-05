package com.example.lcj.proxy.jdkproxy;

public class UserServiceImpl implements IUserService {
    @Override
    public void request() {
        System.out.println("this is userService");
    }
}