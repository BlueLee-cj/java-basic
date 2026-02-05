package com.example.lcj.base.innerclass;

public class DemoClass {
    private int length = 0;

    private class InnerClass implements ILog {
        @Override
        public void Write(String message) {
            System.out.println("DemoClass.InnerClass:" + length);
        }
    }

    public ILog logger() {
        return new InnerClass();
    }

    public static void main(String[] args) {
        DemoClass demoClass = new DemoClass();
        demoClass.logger().Write("abc");

        // new
        DemoClass dc = new DemoClass();
        InnerClass ic = (InnerClass) dc.logger();
        ic.Write("abcde");
    }
}
