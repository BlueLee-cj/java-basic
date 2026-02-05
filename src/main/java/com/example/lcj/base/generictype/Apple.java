package com.example.lcj.base.generictype;

public class Apple implements Fruit<Integer> {
    @Override
    public Integer get(Integer param) {
        return param;
    }
}
