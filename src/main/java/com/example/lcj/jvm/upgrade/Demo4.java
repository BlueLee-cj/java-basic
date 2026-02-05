package com.example.lcj.jvm.upgrade;

/**
 * @author lichengjian
 * @date 2021/7/17
 */
public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(30000);
        while (true) {
            loadData();
        }
    }

    private static void loadData() throws InterruptedException {
        byte[] data = null;
        for (int i = 0; i < 50; i++) {
            data = new byte[100 * 1024];
        }
        data = null;
        Thread.sleep(1000);
    }
}
