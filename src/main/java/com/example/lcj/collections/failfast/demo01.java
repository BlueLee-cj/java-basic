package com.example.lcj.collections.failfast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/12/3 22:16
 */
public class demo01 {
    public static void main(String[] args) {
        method01();
        //method02();
    }
    public static void method01() {
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++ ) {
            list.add(i + "");
        }
        Iterator<String> iterator = list.iterator();
        int i = 0 ;
        while(iterator.hasNext()) {
            if (i == 3) {
                list.remove(3);// iterator.remove(); //迭代器的remove()
            }
            System.out.println(iterator.next());
            i ++;
        }
    }

    public static void method02() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0 ; i < 10 ; i ++ ) {
            map.put(i+"", i+"");
        }
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (i == 3) {
                map.remove(3+"");
            }
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            i++;
        }
    }
}
