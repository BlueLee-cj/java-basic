package com.example.lcj.thread.volatiledemo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ��lcj
 * @description��
 * @modified By��
 * @date ��Created in 2019/7/19 22:01
 */
public class VolatileSerialTest {
    private static volatile int x = 0, y = 0;

    public static void main(String[] args) throws InterruptedException {
        Set<String> resultSet = new HashSet<>();
        Map<String, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < 10000000; i++) {
            x = 0;
            y = 0;
            resultMap.clear();
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    int a = y;
                    x = 1;
                    resultMap.put("a", a);
                }
            });

            Thread other = new Thread(new Runnable() {
                @Override
                public void run() {
                    int b = x;
                    y = 1;
                    resultMap.put("b", b);
                }
            });

            one.start();
            other.start();
            one.join();
            other.join();
            resultSet.add("a=" + resultMap.get("a") + "," + "b=" + resultMap.get("b"));
            System.out.println(resultSet);
        }
    }

}
