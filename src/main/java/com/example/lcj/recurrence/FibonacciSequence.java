package com.example.lcj.recurrence;

public class FibonacciSequence {

    /**
     * @param n
     * @return
     * @description ����ݹ鷨���
     * <p>
     * 쳲������������£�
     * <p>
     * 1,1,2,3,5,8,13,21,34,...
     * <p>
     * ��ô������fib(5)ʱ����Ҫ����1��fib(4),3��fib(3),3��fib(2)������fib(1)������
     * <p>
     * fib(5) = fib(4) + fib(3)
     * <p>
     * fib(4) = fib(3) + fib(2) ��fib(3) = fib(2) + fib(1)
     * <p>
     * fib(3) = fib(2) + fib(1)
     * <p>
     * ���������������ظ����㣬��ʵ��������ֻ�����fib(4)��fib(3)��fib(2)��fib(1)��һ�μ��ɣ�
     * �����optimizeFibonacci�����������Ż���ʹʱ�临�ӶȽ�����O(n).
     * @author rico
     * @created 2017��5��10�� ����12:00:42
     */
    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {     // �ݹ���ֹ����
            return 1;       // ���龰
        }
        return fibonacci(n - 1) + fibonacci(n - 2); // ��ͬ�ظ��߼�����С����Ĺ�ģ
    }


    public static int optimizeFibonacci(int first, int second, int n) {
        if (n > 0) {
            if (n == 1) {    // �ݹ���ֹ����
                return first;       // ���龰
            } else if (n == 2) {            // �ݹ���ֹ����
                return second;      // ���龰
            } else if (n == 3) {         // �ݹ���ֹ����
                return first + second;      // ���龰
            }
            return optimizeFibonacci(second, first + second, n - 1);  // ��ͬ�ظ��߼�����С�����ģ
        }
        return -1;
    }

    public static int fibonacci_loop(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }

        int result = -1;
        int first = 1;      // �Լ�ά����"ջ",�Ա�״̬����
        int second = 1;     // �Լ�ά����"ջ",�Ա�״̬����

        for (int i = 3; i <= n; i++) { // ѭ��
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

    /**
     * @param n
     * @return
     * @description ʹ������洢쳲���������
     * @author rico
     */
    public static int fibonacci_array(int n) {
        if (n > 0) {
            int[] arr = new int[n];   // ʹ����ʱ����洢쳲���������
            arr[0] = arr[1] = 1;

            for (int i = 2; i < n; i++) {   // Ϊ��ʱ���鸳ֵ
                arr[i] = arr[i - 1] + arr[i - 2];
            }
            return arr[n - 1];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        System.out.println(optimizeFibonacci(1, 1, 5));
        System.out.println(fibonacci_loop(5));
        System.out.println(fibonacci_array(5));
    }
}