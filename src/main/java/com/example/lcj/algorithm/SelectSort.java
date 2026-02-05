package com.example.lcj.algorithm;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/11 17:11
 */
public class SelectSort {
    /**
     * 排序算法
     *
     * @param args
     */
    public static void main(String[] args) {
        int a[] = {6, 3, 8, 2, 9, 1};
        //外层控制总共要进行排序的趟数
        for (int x = 0; x < a.length - 1; x++) {
            //内层表示要和下标为X的数据比较数组值
            for (int y = x + 1; y < a.length; y++) {
                if (a[x] > a[y]) {
                    int temp = a[y];
                    a[y] = a[x];
                    a[x] = temp;
                }
            }
        }
        //排序后的数组顺序为
        for (int res : a) {
            System.out.print(" " + res);
        }
    }
}
