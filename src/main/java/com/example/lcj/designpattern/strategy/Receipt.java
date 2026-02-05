package com.example.lcj.designpattern.strategy;

import lombok.Data;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/29 13:40
 */
@Data
public class Receipt {
    String message;
    String type;

    public Receipt(String message, String type) {
        this.message = message;
        this.type = type;
    }
}
