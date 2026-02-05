package com.example.lcj.thread.T227AnyObjectAsObjectMonitor.DityRead;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 11:35
 */
public class MyService {
    public MyOneList addServiceMethod(MyOneList list, String data) throws InterruptedException {
        if (list.getSize() < 1) {
            Thread.sleep(1000);
            list.add(data);
        }
        return list;
    }
}
