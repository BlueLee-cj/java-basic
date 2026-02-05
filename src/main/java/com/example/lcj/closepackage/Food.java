package com.example.lcj.closepackage;

class Food{
    public static final String name = "Food";
    private static int num = 20;

    public Food() {
        System.out.println("Delicious Food");
    }

    public Active getEat() {
        return new EatActive();
    }

    public class EatActive implements Active {

        @Override
        public void eat() {
            if (num == 0) {
                System.out.println("吃货，已经吃没了");
            }
            num --;
            System.out.println("吃货，你吃了一份了");
        }
    }

    public void currentNum() {
        System.out.println("还剩:"+num+"份");
    }
}