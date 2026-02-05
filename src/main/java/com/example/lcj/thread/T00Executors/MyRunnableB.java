package com.example.lcj.thread.T00Executors;

class MyRunnableB implements Runnable {
    public void run() {
        char c = 'A' - 1;
        while (c < 'Z') {
            c++;
            for (int j = 0; j < 1000000; j++) ;
            System.out.println("c=" + c);
        }
    }
}