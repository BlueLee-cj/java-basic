package com.example.lcj.json.fastjson;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lichengjian
 * @date 2021/11/5
 */
@RestController
public class Test {
    @GetMapping(value = "/user/{userId}", produces = "application/json;charset=UTF-8")
    public User delUser(@PathVariable String userId) {
        User user = new User();
        user.setRegDate(new Date());
        user.setReg2Date(new Date());
        return user;
    }
}
