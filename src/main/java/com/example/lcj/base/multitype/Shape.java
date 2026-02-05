package com.example.lcj.base.multitype;

/**
 * @author lichengjian
 * @date 2024/1/7
 */
public abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    public abstract String toString();
}
