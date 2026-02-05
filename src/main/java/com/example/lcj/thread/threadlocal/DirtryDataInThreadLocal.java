package com.example.lcj.thread.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：lcj
 * @description：比如， 用户A 下单后没有看到订单记录，
 * 而用户B 却看到了用户A 的订单记录。通过排查发现是由于session 优化引发的。在
 * 原来的请求过程中，用户每次请求S erver ， 都需要通过sessionld 去缓存里查询用户的
 * session 信息，这样做无疑增加了一次调用。因此，开发工程师决定采用某框架来缓存
 * 每个用户对应的SecurityContext ， 它封装了session 相关信息。优化后虽然会为每个用
 * 户新建一个session 相关的上下文，但是由于Threadlocal 没有在线程处理结束时及时
 * 进行remove（） 清理操作， 在高并发场景下，线程池中的线程可能会读取到上→个线程
 * 缓存的用户信息。为了便于理解，用段简要代码来模拟，如下所示·
 * @date ：Created in 2020/11/14 23:29
 */
public class DirtryDataInThreadLocal {
    public static ThreadLocal<String> threadLocal
            = new ThreadLocal<String>();

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 2; i++) {
            Mythread mythread = new Mythread();
            pool.execute(mythread);
        }
    }

    private static class Mythread extends Thread {
        private static boolean flag = true;

        @Override
        public void run () {
          if (flag) {
              threadLocal.set(this.getName() + ", session info.");
              flag = false;
          }
            System.out.println(this.getName() + " 线程是" + threadLocal.get());
        }

    }
}
