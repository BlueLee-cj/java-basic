/*
 * *     ���ָ������̵߳�ִ��˳��:
 *     ��Ŀ��
 *     ���Թٻ����ٸ����ӣ������10���̰߳���˳���ӡ0123456789
 *
 *     1������һ��������
 * */
package com.example.lcj.thread.demo.sequenceprint1234;

public class LockObject {
    int orderNum = 0;
    final static int MaxValue = 9;

    public LockObject(int orderNum) {
        this.orderNum = orderNum;
    }

}
