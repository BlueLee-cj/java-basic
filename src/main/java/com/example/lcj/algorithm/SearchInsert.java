package com.example.lcj.algorithm;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/2 19:42
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 8};
        int a = 3;
        int b = 6;
        System.out.println(methodA(arr, a));
        System.out.println(methodA(arr, b));
    }

    public static int methodA(int[] arr, int a) {
        int len = arr.length;
        if (len == 0) {
            return 0;
        } else {
            for (int i = 0; i < len; i++) {
                if (arr[0] > a) {
                    return 0;
                } else if (arr[len - 1] < a) {
                    return len;
                } else if (arr[i] == a) {
                    return i;
                } else if (arr[i] < a && arr[i + 1] > a) {
                    return i + 1;
                }
            }
        }
        return len;
    }
}
