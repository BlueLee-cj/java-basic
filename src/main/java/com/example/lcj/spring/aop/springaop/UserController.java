package com.example.lcj.spring.aop.springaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//接口类
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/addUser")
    public int addUser(){
       return userService.addUser();
    }
}