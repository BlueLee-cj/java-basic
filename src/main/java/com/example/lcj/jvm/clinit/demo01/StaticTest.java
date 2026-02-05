package com.example.lcj.jvm.clinit.demo01;

/**
 * 父类的类构造器<clinit>() -> 子类的类构造器<clinit>()
 * -> 父类的成员变量和实例代码块 -> 父类的构造函数
 * -> 子类的成员变量和实例代码块 -> 子类的构造函数。
 */
public class StaticTest {
    public static void main(String[] args) {
        new StaticTest();
        //staticFunction();
    }
    /*
    * 也就是实例化StaticTest对象，但这个时候类都没有初始化完毕啊，
    * 能直接进行实例化吗？
    * 事实上，这涉及到一个根本问题就是：实例初始化不一定要在类初始化结束之后才开始初始化。
    */
    //static StaticTest st = new StaticTest();

    static {   //静态代码块
        System.out.println("1");
    }

    {       // 实例代码块
        System.out.println("2");
    }

    StaticTest() {    // 实例构造器
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {   // 静态方法
        System.out.println("4");
    }

    int a = 110;    // 实例变量
    static int b = 112;     // 静态变量
}

/* Output:
        2
        3
        a=110,b=0
        1
        4
 *///:~