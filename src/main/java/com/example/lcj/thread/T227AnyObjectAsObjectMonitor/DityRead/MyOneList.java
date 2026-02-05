package com.example.lcj.thread.T227AnyObjectAsObjectMonitor.DityRead;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 11:32
 */
public class MyOneList {
    private List list = new ArrayList();

    synchronized public void add(String data) {
        list.add(data);
    }

    synchronized public int getSize() {
        return list.size();
    }
}
