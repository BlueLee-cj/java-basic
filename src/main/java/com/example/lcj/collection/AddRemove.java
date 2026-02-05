package com.example.lcj.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author lichengjian
 * @date 2021/10/4
 */
public class AddRemove {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (true) {
                iterator.remove();
            }
        }
    }
}
