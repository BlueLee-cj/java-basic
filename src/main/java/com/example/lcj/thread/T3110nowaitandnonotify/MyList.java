package com.example.lcj.thread.T3110nowaitandnonotify;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/12/9 21:37
 */
public class MyList {
    private volatile List list = new ArrayList<>();

    public void add() {
        list.add("lcj");
    }

    public int size() {
        return list.size();
    }
}
