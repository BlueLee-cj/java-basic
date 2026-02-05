package com.example.lcj.base.genericity;

import java.util.ArrayList;
import java.util.List;

import com.example.lcj.base.paramquote.Person;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * @author lichengjian
 * @date 2021/6/25
 */
public class Test {
    public static void main1(String[] args) {
        // 创建可以存储String的ArrayList:
        ArrayList<String> strList = new ArrayList<String>();
        // 创建可以存储Float的ArrayList:
        ArrayList<Float> floatList = new ArrayList<Float>();
        // 创建可以存储Person的ArrayList:
        ArrayList<Person> personList = new ArrayList<Person>();

        strList.add("hello"); // OK
        String s = strList.get(0); // OK
        // strList.add(new Integer(123)); // compile error!
        // Integer n = strList.get(0); // compile error!


        // 创建ArrayList<Integer>类型：
        ArrayList<Integer> integerList = new ArrayList<Integer>();
        // 添加一个Integer：
        integerList.add(new Integer(123));

        // “向上转型”为ArrayList<Number>：
        // ArrayList<Number> numberList = integerList;
        // 要特别注意：不能把ArrayList<Integer>向上转型为ArrayList<Number>或List<Number>。

        ArrayList<Number> numberList = new ArrayList<Number>();
        // 添加一个Float，因为Float也是Number：
        numberList.add(new Float(12.34));
        // 从ArrayList<Integer>获取索引为1的元素（即添加的Float）：
        // Integer n = integerList.get(1); // ClassCastException!

        // 注意泛型的继承关系：可以把ArrayList<Integer>向上转型为List<Integer>（T不能变！），
        // 但不能把ArrayList<Integer>向上转型为ArrayList<Number>（T不能变成父类）。

        List list = new ArrayList();
        list.add("Hello");
        list.add("World");
        String first = (String) list.get(0);
        String second = (String) list.get(1);
    }

    private static <E extends Number> E getNumber(String text) {
        // JSONObject.parseArray()
        System.out.println("=========");
        return (E) Double.valueOf(text);
    }

    private static <E extends Number> E getNumber2(String text, TypeReference<E> type) {

        System.out.println("------");
        return null;
    }

    public static void main(String[] args) {
        Double number = getNumber("222");
        List<String> sss = getNumber("222");

        Number sss1 = getNumber("sss");
        
        List<Double> aa = getNumber("aaa");
        // String bb = getNumber("bbb");
        Double cc = getNumber("ccc");

        // Number ddd = getNumber2("ddd", new TypeReference<Number>() {});
        //
        // String eee = getNumber2("eee", new TypeReference<String>() {});

        Integer ggg = getNumber2("eee", new TypeReference<Integer>() {});
    }

}
