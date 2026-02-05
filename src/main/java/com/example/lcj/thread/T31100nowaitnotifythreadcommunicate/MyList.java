package com.example.lcj.thread.T31100nowaitnotifythreadcommunicate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/5 22:44
 */
public class MyList {
    private volatile List list = new ArrayList();

    public void add() {
        list.add("李成建");
    }

    public int size() {
        return list.size();
    }
}
