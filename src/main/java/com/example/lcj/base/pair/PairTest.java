package com.example.lcj.base.pair;

import java.util.*;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import com.alibaba.fastjson.JSONObject;


/**
 * @author lichengjian
 * @date 2021/4/11
 */
public class PairTest {
    public static void main(String[] args) {
        // Pair<Integer, String> pair = new Pair<>(1, "One");
        // Integer key = pair.getKey();
        // String value = pair.getValue();

        AbstractMap.SimpleEntry<Integer, String> entry = new AbstractMap.SimpleEntry<>(1, "one");
        Integer key1 = entry.getKey();
        String value1 = entry.getValue();

        AbstractMap.SimpleImmutableEntry<Integer, String> entry1 = new AbstractMap.SimpleImmutableEntry<>(1, "one");
        // entry1.setValue("two");


        Pair<Integer, String> pair2 = Pair.of(2, "two");
        Integer key2 = pair2.getKey();
        String value2 = pair2.getValue();
        Integer key3 = pair2.getLeft();
        String value3 = pair2.getRight();
        System.out.println("--------------------------");


        ImmutablePair<Integer, String> pair = new ImmutablePair<>(2, "Two");
        Integer key = pair.getKey();
        String value = pair.getValue();
        Integer key4 = pair.getLeft();
        String value4 = pair.getRight();


        // 使用Pair来排序
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("a", 9);
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("a", 4);
        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("a", 7);
        JSONObject jsonObject4 = new JSONObject();
        jsonObject4.put("a", 8);


        ArrayList<Pair<Integer, JSONObject>> pairs = new ArrayList<>();
        pairs.add(Pair.of(1, jsonObject1));
        pairs.add(Pair.of(2, jsonObject2));
        pairs.add(Pair.of(3, jsonObject3));
        pairs.add(Pair.of(4, jsonObject4));

        List<Pair<Integer, JSONObject>> result = pairs.stream()
                .sorted(Comparator.comparingInt(o -> o.getRight().getInteger("a"))).collect(Collectors.toList());
        result.forEach(System.out::println);

        System.out.println("==============================");

        // 使用map来排序
        HashMap<Integer, JSONObject> integerJSONObjectHashMap = new HashMap<>();
        integerJSONObjectHashMap.put(1, jsonObject1);
        integerJSONObjectHashMap.put(2, jsonObject2);
        integerJSONObjectHashMap.put(3, jsonObject3);
        integerJSONObjectHashMap.put(4, jsonObject4);

        List<Map.Entry<Integer, JSONObject>> result2 = integerJSONObjectHashMap.entrySet().stream()
                .sorted(Comparator.comparingInt(o -> o.getValue().getInteger("a"))).collect(Collectors.toList());
        result2.forEach(System.out::println);



    }
}
