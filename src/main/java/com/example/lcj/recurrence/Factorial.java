package com.example.lcj.recurrence;

/**
 * Title: �׳˵�ʵ��
 * Description:
 * �ݹ�ⷨ
 * �ǵݹ�ⷨ
 *
 * @author rico
 */
public class Factorial {
    /**
     * @param n
     * @return
     * @description �׳˵ĵݹ�ʵ��
     * @author rico
     * @created 2017��5��10�� ����8:45:48
     */
    public static long f(int n) {
        if (n == 1)   // �ݹ���ֹ����
            return 1;    // ���龰

        return n * f(n - 1);  // ��ͬ�ظ��߼�����С����Ĺ�ģ
    }

///--------------------------------���Ƿָ���-------------------------------------

    /**
     * @param n
     * @return
     * @description �׳˵ķǵݹ�ʵ��
     * @author rico
     * @created 2017��5��10�� ����8:46:43
     */
    public static long f_loop(int n) {
        long result = n;
        while (n > 1) {
            n--;
            result = result * n;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(f(5));
        System.out.println(f_loop(5));
    }
}