package com.example.lcj.jdk8NewSyntax.default2;

/**
 * 实现接口Interface1
 */
// public class MyImplement implements Interface1 {
// public static void main(String[] args) {
// MyImplement myImplement = new MyImplement();
// // 直接调用helloWorld()方法
// myImplement.helloWorld();
// }
// }

/**
 * 发生这种情况的原因是，实现类MyImplement即实现了接口Interface1又实现了接口Interface2，恰巧两个接口中都定义可相同的默认方法。说白了就是编译器此时已经被干懵了，当我们在MyImplement类中调用方法时，它不知道该去调用Interface1的默认方法还是去调用Interface2的方法。解决方法就是在实现类中实现该方法
 * ————————————————
 * 版权声明：本文为CSDN博主「A股慈善家」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/qq_35835624/article/details/80196932
 */

/**
 * 实现接口Interface1,Interface2
 */
public class MyImplement implements Interface1, Interface2 {
    public static void main(String[] args) {
        MyImplement myImplement = new MyImplement();
        // 直接调用helloWorld()方法
        myImplement.helloWorld();
    }

    @Override
    public void helloWorld() {
        System.out.println("hi i'm from MyImplement");
    }
}
