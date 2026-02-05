package com.example.lcj.jvm.object.loader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/6/18 21:06
 */
public class A4 {
    private  static final List<String> NAMES = new ArrayList(){
        {
            add("lcj");
            System.out.print(NAMES);
        }
    };

    private  static void add(String str){
        NAMES.add(str);
    };

    public static void main(String[] args) {

    }
}
/**
 * ,main方法里是空的,怎么输出啊？原来啊,在我们执行main方法之前,Jvm的classLoader需要将这个类加载到内存,
 * 首先加载的就是被static修饰的变量，也就是全局变量。这里先声明一个List 集合,
 * 然后在堆中创建一个ArrayList的子类对象,大家看这个对象的创建方法是不是与我们平时创建对象的方式是不是不太一样呢？
 * 这个叫做匿名内部类,匿名内部类被创建时会执行它的方法,因为它的匿名内部类,所以和我们平时通过对象调用方法不太一样,
 * 这里没有显示调用它的对象名,但是方法还是被执行了。先对集合添加一个子串,然后打印集合中的内容，那么打印出来的是什么呢？
 * 结果是null,为什么呢？因为在内部类的方法执行完成之前,还没有结束对象的创建,所以声明NAMES的引用并没有与堆中任一对象进行连接,
 * 此处打印的相当于List<String> NAMES;
 * 只完成了前半段语句,所以打印出来的是空的,如果等内部类中方法都结束时,
 * 在main中重新打印NAMES的内容才可以看到集合中的元素。这道题主要考察的是Java实例化一个对象在堆栈中的过程。
 */
