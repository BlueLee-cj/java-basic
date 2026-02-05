package com.example.lcj.closepackage;

/**
 * Created by Ung8023
 * 测试java中的闭包
 */

public class TestClosure {
    public static void main(String[] args) {
        Food food = new Food();

        food.getEat().eat();
        food.getEat().eat();

        //在内部类是public修饰时，可以通过以下方式
         Food foodPub = new Food();
         Food.EatActive eat = foodPub.new EatActive();
         eat.eat();
    }

}


