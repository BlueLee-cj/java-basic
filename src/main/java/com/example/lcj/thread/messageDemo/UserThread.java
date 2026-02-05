package com.example.lcj.thread.messageDemo;

import java.util.ArrayList;
import java.util.List;

public class UserThread implements Runnable {

    private List<User> userList;

    public UserThread() {
        super();
    }

    public UserThread(List<User> userList) {
        this();
        this.userList = userList;
    }

    // run����ִ�з��Ͷ���
    @Override
    public void run() {
        for (User user : userList) {
            System.out.println(Thread.currentThread().getName() + " ���� " + user + "���Ͷ���  ");
        }
    }

    // ��ʼ���û���Ϣ�ķ���
    public static List<User> init() {
        List<User> userList = new ArrayList<User>();
        for (Integer i = 1; i <= 11; i++) {
            User user = new User(i.toString(), i.toString());
            userList.add(user);
        }
        return userList;
    }

    public static void main(String[] args) {
        // ��ʼ���û���Ϣ
        List<User> allUserList = init();
        // ������Ϊÿ���̷߳��������û�
        int threadSize = 2;
        // ���÷��䷽��
        List<List<User>> splitUserList = ListUtils.splitList(allUserList, threadSize);
        for (int i = 0; i < splitUserList.size(); i++) {
            List<User> list = splitUserList.get(i);
            // �������ŷ����̣߳�ִ���߳�
            UserThread ut = new UserThread(list);
            Thread t = new Thread(ut);
            t.start();
        }
    }
}
