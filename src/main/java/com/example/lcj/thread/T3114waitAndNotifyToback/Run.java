package com.example.lcj.thread.T3114waitAndNotifyToback;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/7 12:25
 */
public class Run {
    public static void main(String[] args) {
        DBtools dBtools = new DBtools();
        for (int i = 0; i < 10; i++) {
            BackupB backupB = new BackupB(dBtools);
            backupB.start();
            BackupA backupA = new BackupA(dBtools);
            backupA.start();
        }
    }
}
