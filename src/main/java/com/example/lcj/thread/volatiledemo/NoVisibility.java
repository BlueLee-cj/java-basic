package com.example.lcj.thread.volatiledemo;

public class NoVisibility {
     //private static volatile boolean ready = false;
     private static boolean ready;
     private static int number;
     private static class ReaderThread extends Thread {
         @Override
         public void run() {
             while(!ready) {
                 System.out.println("=====");
             }
             System.out.println(number);
         }
     }
     public static void main(String[] args) throws InterruptedException {
         new ReaderThread().start();
         Thread.sleep(10);
         ready = true;
         Thread.sleep(10);
         number = 42;
     }
 }