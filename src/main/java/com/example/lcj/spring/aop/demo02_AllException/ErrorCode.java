package com.example.lcj.spring.aop.demo02_AllException;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    INTERNAL_SERVICE_ERROR(500100, "服务端异常"),

    PASSWORD_CAN_NOT_BE_NULL(500211, "登录密码不能为空"),

    PASSWORD_ERROR(500215, "密码错误");
    
    private int code;

    private String msg;
}