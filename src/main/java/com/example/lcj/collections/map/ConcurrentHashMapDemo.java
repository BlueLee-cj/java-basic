package com.example.lcj.collections.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/6/13 20:45
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
    }
    //并发集合，使用Iterator进行遍历的时候对集合进行操作，不存在快速失败问题
    public static Map ConcurrentHashMap() {
        ConcurrentHashMap<String,String> map=new ConcurrentHashMap<String,String>();
        map.put("name", "易哈哈");
        map.put("age", "18");
        //keySet是键的集合，entrySet()键值对的集合
        Iterator<Map.Entry<String,String>> mapiterator= map.entrySet().iterator();
        while(mapiterator.hasNext()) {
            System.out.println(mapiterator.next().getValue());
            map.remove("name");//正常
        }
        map.get("name");
        return map;
    }

}
