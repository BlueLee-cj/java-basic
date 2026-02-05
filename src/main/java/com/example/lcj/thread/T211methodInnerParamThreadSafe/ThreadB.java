package com.example.lcj.thread.T211methodInnerParamThreadSafe;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/20 17:28
 */
public class ThreadB extends Thread {
    private HasSelfPrivateNum hasSelfPrivateNum;

    public ThreadB(HasSelfPrivateNum has) {
        super();
        this.hasSelfPrivateNum = has;
    }

    @Override
    public void run() {
        super.run();
        hasSelfPrivateNum.addI("b");
    }
}
