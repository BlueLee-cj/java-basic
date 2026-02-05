package com.example.lcj.collections.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/6/13 19:10
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Float aFloat = Float.valueOf("22");
        System.out.println(Float.isNaN(aFloat));
        HashMap<String, String> hashMap = new HashMap<>();
        String key = "帅丙";
        String value = "520";
        hashMap.put(key,value);
        int hashcode = key.hashCode();
        System.out.println(hashcode);
        hashMap.put(null,value);
        System.out.println(hashMap.get(null));

        Map map=new HashMap();
        map.put("a", "bbbb");
        map.put("b", "aaaa");
        map.put("c", "ccc");
        map.put("d", "ddd");

        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Object key1 = iterator.next();
            System.out.println("map.get(key) is :"+map.get(key1));
            iterator.remove();
        }
        System.out.println("map.get(key) is :"+map.get("a"));



        HashMap<String, String> table = new HashMap<String, String>();
        table.put("a", "aa");
        table.put("b", "dd");
        table.put("c", "cc");
        Iterator<Map.Entry<String, String>> iterator1 = table.entrySet().iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next().getValue());
            //1.使用iterator的方法操作元素，可以正常运行
            //iterator.remove();
            //2.使用集合的方法操作元素，会报ConcurrentModificationException异常
            table.put("d", "dd");
            //table.remove("c");
        }
    }
}
