package com.example.lcj.thread.demo.sequenceprint1234.way;

import java.util.ArrayList;
import java.util.List;


public class TestThreadOderprint {
    static LockObject lockObject = new LockObject();

    public static void main(String[] args) {
        List<IThread> list1 = new ArrayList<IThread>();
        for (int i = 0; i < 100; i++) {
            IThread iThread = new IThread();
            iThread.setlObject(lockObject);
            iThread.run();
        }


    }

}
