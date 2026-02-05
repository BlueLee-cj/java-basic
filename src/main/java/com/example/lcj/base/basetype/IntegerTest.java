package com.example.lcj.base.basetype;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/4/28 16:22
 */
public class IntegerTest {

    public static void main(String[] args) {

        Integer ageFromInput = 1;
        Integer age = 1;

        if(ageFromInput - age != 0){
            throw new RuntimeException("关系人年龄录入错误,应与身份证保持一致!");
        }else {
            System.out.println(ageFromInput - age == 0);
        }
    }

}
