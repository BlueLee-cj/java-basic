package com.example.lcj.base.finaltest.finalDatas;

import java.util.Random;

/**
 * @author lichengjian
 * @date 2023/12/24
 */
public class FinalData {

    private static Random and = new Random(47);
    private String id;

    public FinalData(String id) {
        this.id = id;
    }

    private final int valueOne = 9;

    private static final int VALUE_TWO = 99;
    public static final int VALUE_THREE = 39;
    private final int INT_5 = and.nextInt(20);

    public static void main(String[] args) {
        System.out.println(1);
    }
}
