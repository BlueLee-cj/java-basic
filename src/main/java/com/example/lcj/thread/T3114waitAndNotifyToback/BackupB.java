package com.example.lcj.thread.T3114waitAndNotifyToback;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/7 12:23
 */
public class BackupB extends Thread {
    private DBtools dBtools;

    public BackupB(DBtools dBtools) {
        this.dBtools = dBtools;
    }

    @Override
    public void run() {
        dBtools.backupB();
    }
}
