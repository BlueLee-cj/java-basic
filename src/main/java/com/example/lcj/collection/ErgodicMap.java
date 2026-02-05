package com.example.lcj.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author lichengjian
 * @date 2021/10/4
 */
public class ErgodicMap {
    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        // 遍历map中的键
        for (Integer key : map.keySet()) {

            System.out.println("Key = " + key);

        }

        // 遍历map中的值
        for (Integer value : map.values()) {

            System.out.println("Value = " + value);

        }



        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {

            Map.Entry<Integer, Integer> entry = entries.next();

            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

        }

    }
}
