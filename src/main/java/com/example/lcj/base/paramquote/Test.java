package com.example.lcj.base.paramquote;

/**
 * @author ：lcj
 * @description：Java参数引用传递之例外：null
 * 众所周知的是，java中除基本类型外，参数都是引用传递。
 * 但是，有一个例外，就是当实参为null时，其实，它依然是一个值传递。
 * 也就是说，传参为null，不管函数体内用这个参数做了什么，跳出函数体后该参数依然是null
 * 或者说，引用传递退化成为了值传递。
 * 再进一步分析，其实是基本类型和指向null的非基本类型的指针，都在栈而非堆中，而引用传递的是堆内存地址。
 * 类似的还有String类型。
 * @date ：Created in 2020/4/8 9:20
 */
public class Test {
    public static void main(String[] args) {
        Person p = new Person();
        create(p);
        System.out.println(p);
    }

    private static void create(Person p) {
        if(p == null){
            p = new Person();
        }
        p.setName("lcj");
        Animal a = new Animal();
        p.setAnimal(a);
    }
}
