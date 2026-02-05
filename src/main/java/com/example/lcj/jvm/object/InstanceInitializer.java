package com.example.lcj.jvm.object;

public class InstanceInitializer {
    private int i = 1;
    private int j;

    {
        j = i;
    }
}

//public class InstanceInitializer {
//    private int j = i;
//    private int i = 1;
//}

