package com.example.lcj.collections.streamcollectors;

import com.example.lcj.collections.collection2map.Student;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/8/7 17:17
 */
public class CollectorsDemo {
    public static void main(String[] args) {
        //method01();
        //Student student = null;
        try {
            new BigDecimal("ss");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage().contains("111"));
        }


    }

    private static void method01() {

        //List<Pair<String, DoubleTest>> pairArrayList = new ArrayList<Pair<String, DoubleTest>>(3);
        //pairArrayList.add(new Pair<>("version", 12.10));
        //pairArrayList.add(new Pair<>("version", 12.19));
        //pairArrayList.add(new Pair<>("version", 6.28));
        ////Map<String, DoubleTest> map = pairArrayList.stream().collect(
        //// 生成的map集合中只有一个键值对：{version=6.28}
        ////Collectors.toMap(Pair::ge, Pair::getValue, (v1, v2) -> v2));
        //
        //String[] departments = new String[] {"iERP", "iERP", "EIBU"};
        //// 抛出IllegalStateException异常
        //Map<Integer, String> map1 = Arrays.stream(departments)
        //        .collect(Collectors.toMap(String::hashCode, str -> str));
    }
}
