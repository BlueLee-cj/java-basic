package com.example.lcj.collections.arraytocollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysAsList {
    public static void main(String[] args) {
        String[] stringArray = new String[3];
        stringArray[0] = "one";
        stringArray[1] = "two";
        stringArray[2] = "three";
        List<String> stringList = Arrays.asList(stringArray);
        stringList.set(0, "onelist");
        System.out.println(stringArray[0]);
        stringList.add("four");
        ArrayList<Object> objects = new ArrayList<>(Arrays.asList(stringArray));
        objects.add("four");
        objects.remove(2);
        objects.clear();
    }
}
