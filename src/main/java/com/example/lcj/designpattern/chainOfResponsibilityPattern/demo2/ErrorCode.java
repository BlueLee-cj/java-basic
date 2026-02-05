package com.example.lcj.designpattern.chainOfResponsibilityPattern.demo2;

public enum ErrorCode {
    PARAM_NULL_ERROR(700010, "生成 qiniu svg 失败"),
    PARAM_SKU_NULL_ERROR(700011, "SkuId商品主键参数必填校验"),
    PARAM_PRICE_NULL_ERROR(700011, "Price价格参数必填校验"),
    PARAM_STOCK_NULL_ERROR(700012, "Stock库存参数必填校验"),

    PARAM_PRICE_ILLEGAL_ERROR(700013, "非法价格校验"),
    PARAM_STOCK_ILLEGAL_ERROR(700014, "非法库存校验"),
    ;

    int httpStatus;
    int code;
    String msg;

    ErrorCode(int code, String msg) {
        this.httpStatus = 400;
        this.code = code;
        this.msg = msg;
    }

    ErrorCode(int httpStatus, int code, String msg) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.msg = msg;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
