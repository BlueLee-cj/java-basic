package com.example.lcj.base.innerclass;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/10/23 16:18
 */
public class Test {
    private int a;

    public static void main(String[] args) {
        Test test = new Test();
        test.method01();
        System.out.println("---------b----------");
        B b = new Test().new B();
        b.methodB();
        System.out.println("---------c----------");
        C c = new C();
        c.methodC();

    }

    public void method01() {
        int a = 11;
        A a1 = new A() {
            @Override
            public void method() {
                System.out.println("111");
                System.out.println(a);
            }
        };
        a1.method();
    }

    public class B {
        private int b;

        public void methodB() {
            System.out.println(a);
            System.out.println("222");
        }
    }

    public static class C {
        private int c;

        public void methodC() {
            // System.out.println(a);
            System.out.println("333");
        }
    }
}
