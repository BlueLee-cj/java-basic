package com.example.lcj.designpattern.chainOfResponsibilityPattern.demo2;

import lombok.Data;

/**
 * @author lichengjian
 * @date 2024/4/29
 */
@Data
public class Result {
    private boolean success;
    private Object data;
    private int errorCode;
    private String text;

    public Result(boolean ok, Object data, int errorCode, String text) {
        this.success = ok;
        this.data = data;
        this.errorCode = errorCode;
        this.text = text;
    }

    public static Result success() {
        return new Result(true, "ok", 0, "");
    }

    public static Result failure(ErrorCode errorCode) {
        return new Result(false, "ok", errorCode.code, errorCode.msg);
    }

}
