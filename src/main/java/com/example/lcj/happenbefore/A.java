package com.example.lcj.happenbefore;

import java.math.BigDecimal;

public class A {
   public int var;

   private static A a = new A();

   private A(){}

   public static A getInstance(){
       return a;
   }

   public synchronized void method1(){
       var = 3;
       System.out.println(var);
   }

   public synchronized void method2(){
       int b = var;
       System.out.println(b);
   }

   public void method3() throws InterruptedException {
       synchronized(new A()){ //注意这里和method1 method2 用的可不是同一个锁哦
           Thread.sleep(1000);
           var = 4;
       }
   }

    public static void main(String[] args) throws InterruptedException {
        //线程1执行的代码：
        A.getInstance().method1();

        //线程3执行的代码：
        A.getInstance().method3();

        //线程2执行的代码：
        A.getInstance().method2();


    }
    /**
     * 如果某个时刻执行完“线程1” 马上执行“线程2”，
     * 因为“线程1”执行A类的method1方法后肯定要释放锁，
     * “线程2”在执行A类的method2方法前要先拿到锁，符合“锁的happen-before原则”，
     * 那么在“线程2”method2方法中的变量var一定是3，所以变量b的值也一定是3。
     * 但是如果是“线程1”、“线程3”、“线程2”这个顺序，
     * 那么最后“线程2”method2方法中的b值是3，还是4呢？
     * 其结果是可能是3，也可能是4。
     * 的 确“线程3”在执行完method3方法后的确要unlock，
     * 然后“线程2”有个lock，但是这两个线程用的不是同一个锁，
     * 所以JMM这个两个操作之间不符合八大happen-before中的任何一条，
     * 所以JMM不能保证“线程3”对var变量的修改对“线程2”一定可见，虽然“线程3”先于“线程2”发生。
     *
     */
}