package com.example.lcj.jvm.object.loader;

public class NotInitialization{
    public static void main(String[] args){
        //System.out.println(SubClass.value);
        //通过数组定义来引用类，不会触发此类的初始化
        /**
         * 例运行之后并没有任何输出，
         * 说明虚拟机并没有初始化类SClass。
         * 但是，这段代码触发了另外一个名为[Lcn.edu.tju.rico.SClass的类的初始化。
         * 从类名称我们可以看出，这个类代表了元素类型为SClass的一维数组，
         * 它是由虚拟机自动生成的，直接继承于Object的子类，创建动作由字节码指令newarray触发。
         *
         */
        //SClass[] sca = new SClass[10];

        //System.out.println(ConstClass.CONSTANT);
        //new ConstClass();
    }
}

/* Output:
        SSClass
        SClass init!
        123     
 *///:~


/* Output:
        hello world
 *///: