package com.example.lcj.thread.T213ManyObjectManyLock;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/20 17:28
 */
public class ThreadA extends Thread {
    private HasSelfPrivateNum hasSelfPrivateNum;

    public ThreadA(HasSelfPrivateNum has) {
        super();
        this.hasSelfPrivateNum = has;
    }

    @Override
    public void run() {
        super.run();
        hasSelfPrivateNum.addI("a");
    }
}
