package com.example.lcj.thread.T227AnyObjectAsObjectMonitor;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 9:53
 */
public class Service {
    private String userName;
    private String passWorf;
    private String anyString = new String();

    public void serUserNameAndPassWord(String userName, String passWorf) {
        try {
            synchronized (anyString) {
                System.out.println("ThreadName =" + Thread.currentThread().getName() + " run beginTime =  " + System.currentTimeMillis());
                this.passWorf = passWorf;
                Thread.sleep(3000);
                this.userName = userName;
                System.out.println("ThreadName =" + Thread.currentThread().getName() + " run endTime =  " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
