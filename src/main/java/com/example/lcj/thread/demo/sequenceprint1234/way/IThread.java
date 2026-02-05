package com.example.lcj.thread.demo.sequenceprint1234.way;

public class IThread implements Runnable {
    private LockObject lObject;

    public void setlObject(LockObject lObject) {
        this.lObject = lObject;
    }

    public int id;

    public IThread() {
    }

    public IThread(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public void run() {
        synchronized (lObject) {
            if (lObject.getValue() < lObject.maxvalue) {
                System.out.println(lObject.getValue());
                lObject.setValue(lObject.getValue() + 1);
            }
        }
    }
}
