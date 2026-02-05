package com.example.lcj.jvm.initTime;


public class NotInitialization{
    public static void main(String[] args){
        //=====================1======================
        //System.out.println(SubClass.value);
        //int a = SubClass.a;
        //int value = SubClass.value;
        /***
         * 对于静态字段，只有直接定义这个字段的类才会被初始化，因此通过其子类来引用父类中定义的静态字段，
         * 只会触发父类的初始化而不会触发子类的初始化。在本例中，由于value字段是在类SClass中定义的，
         * 因此该类会被初始化；此外，在初始化类SClass时，虚拟机会发现其父类SSClass还未被初始化，
         * 因此虚拟机将先初始化父类SSClass，然后初始化子类SClass，而SubClass始终不会被初始化。
         */

        //=====================2======================
        //SClass[] sca = new SClass[10];
        /**
         * 案例运行之后并没有任何输出，说明虚拟机并没有初始化类SClass。
         * 但是，这段代码触发了另外一个名为[Lcn.edu.tju.rico.SClass的类的初始化。
         * 从类名称我们可以看出，这个类代表了元素类型为SClass的一维数组，
         * 它是由虚拟机自动生成的，直接继承于Object的子类，创建动作由字节码指令newarray触发。
         */

        //=====================3======================
        //System.out.println(ConstClass.CONSTANT);
        /**
         * 上述代码运行之后，只输出 “hello world”，这是因为虽然在Java源码中引用了ConstClass类中的常量CONSTANT，
         * 但是编译阶段将此常量的值“hello world”存储到了NotInitialization常量池中，
         * 对常量ConstClass.CONSTANT的引用实际都被转化为NotInitialization类对自身常量池的引用了。
         * 也就是说，实际上NotInitialization的Class文件之中并没有ConstClass类的符号引用入口，
         * 这两个类在编译为Class文件之后就不存在关系了。
         */
    }
}

