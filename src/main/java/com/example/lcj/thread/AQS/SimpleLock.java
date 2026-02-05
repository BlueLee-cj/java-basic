package com.example.lcj.thread.AQS;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class SimpleLock {

    private final Sync sync = new Sync();

    // 继承 AQS
    private static class Sync extends AbstractQueuedSynchronizer {

        // 尝试获取锁
        @Override
        protected boolean tryAcquire(int arg) {
            // CAS 把 state 从 0 改成 1
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        // 尝试释放锁
        @Override
        protected boolean tryRelease(int arg) {
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // 是否被当前线程持有
        @Override
        protected boolean isHeldExclusively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }
    }

    public void lock() {
        sync.acquire(1);
    }

    public void unlock() {
        sync.release(1);
    }

    public static void main(String[] args) {
        SimpleLock lock = new SimpleLock();

        lock.lock();
        try {
            // 临界区代码
        } finally {
            lock.unlock();
        }
    }
}
