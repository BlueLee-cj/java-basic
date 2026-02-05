package com.example.lcj.spring.aop.demo02_AllException;

public class GlobalException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    private int errorCode;
    
    public GlobalException(int errorCode) {
        this.errorCode = errorCode;
    }

    public GlobalException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.errorCode =  errorCode.getCode();
    }
}
