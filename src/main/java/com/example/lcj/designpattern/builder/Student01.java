package com.example.lcj.designpattern.builder;

import lombok.Builder;
import lombok.Data;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/29 11:16
 */
@Data
@Builder
public class Student01 {
    private String name;
    private int age;
    private int gender;
}
