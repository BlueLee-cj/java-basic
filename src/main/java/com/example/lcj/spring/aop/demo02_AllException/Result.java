package com.example.lcj.spring.aop.demo02_AllException;

import lombok.Data;

// 统一返回的参数
@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;
    
    
//    public static <T> Result<T> success(T data){
//        return new Result<T>(data);
//    }
//
//    public static <T> Result<T> error(ErrorCode cm){
//        return new Result<T>(cm.getMsg());
//    }
}