package com.example.lcj.base.generictype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichengjian
 * @date 2021/10/21
 */
public class GenericCharTest {
    public static void main(String[] args) {
        /**
         * 1.创建泛型为Number的List类，Integer、DoubleTest、Long等都是Number的子类
         * new ArrayList<>() 等价于 new ArrayList<Number>()
         */
        List<Number> numberList = new ArrayList<Number>();

        /**
         * 2.添加不同子类
         */
        numberList.add(1);
        // 添加Integer类型
        numberList.add(0.5);
        // 添加Double类型
        numberList.add(10000L);
        // 添加Long类型

        /**
         * 3.创建泛型为Number的List类，Integer、DoubleTest、Long等都是Number的子类
         * 引用是泛型类别是Number，但具体实现指定的泛型是Integer
         */
        // List<Number> numberListTwo = new ArrayList<Integer>();
        // err 异常编译不通过

        /**
         * 4.创建泛型为Integer的List类，把该对象的引用地址指向泛型为Number的List
         */
        List<Integer> integerList = new ArrayList<Integer>();
        // List<Number> numberListThree = integerList;
        // err 异常编译不通过


        /**
         * 1.上边界通配符，Number与Number子类
         */
        List<? extends Number> numberListFour = new ArrayList<Number>();
        numberListFour = new ArrayList<Integer>();
        numberListFour = new ArrayList<Double>();
        numberListFour = new ArrayList<Long>();

        /**
         * 2.下边界通配符,Integer与Integer父类
         */
        List<? super Integer> integerList1 = new ArrayList<Integer>();
        integerList1 = new ArrayList<Number>();
        integerList1 = new ArrayList<Object>();

        /**
         * 3. 无界通配符,类型不确定，任意类型
         */
        List<?> list1 = new ArrayList<Integer>();
        list1 = new ArrayList<Number>();
        list1 = new ArrayList<Object>();
        list1 = new ArrayList<String>();

        /**
         * 上边界通配符只读不写，下边界通配符只写不读到底是什么意思，用最简单的话来说
         *
         * <? extends T>上边界通配符不作为函数入参，只作为函数返回类型，
         * 比如List<? extends T>的使用add函数会编译不通过，get函数则没问题
         * <? super T>下边界通配符不作为函数返回类型，只作为函数入参，
         * 比如List<? super T>的add函数正常调用，get函数也没问题，但只会返回Object，所以意义不大
         * 大家只需要记住上面的规则即可，如果想知道为什么这样设计，
         * 可以去了解下P E C S (producer-extends,consumer-super)原则
         */

    }
}
