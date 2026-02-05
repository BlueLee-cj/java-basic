package com.example.lcj.designpattern.adapter.demo01;

public class AC220 implements AC {
    public final int output = 220;

    @Override
    public int outputAC() {
        return output;
    }
}