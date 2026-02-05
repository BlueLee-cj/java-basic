package com.example.lcj.designpattern.adapter.demo01;

public class AC110 implements AC {
    public final int output = 110;

    @Override
    public int outputAC() {
        return output;
    }
}