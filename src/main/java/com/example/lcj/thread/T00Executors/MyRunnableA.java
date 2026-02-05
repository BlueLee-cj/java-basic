package com.example.lcj.thread.T00Executors;

class MyRunnableA implements Runnable {

    public void run() {
        System.out.println("Runnable:run()....");
        int i = 0;
        while (i < 20) {
            i++;
            for (int j = 0; j < 1000000; j++) ;
            System.out.println("i=" + i);
        }
    }
}