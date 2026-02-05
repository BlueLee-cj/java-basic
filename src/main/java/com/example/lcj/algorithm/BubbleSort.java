package com.example.lcj.algorithm;

import com.google.common.primitives.Ints;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/11 17:11
 */
public class BubbleSort {
    public static void main(String[] args) {
        System.out.println("1".equals(null));

        int a[] = {6, 3, 8, 2, 9, 1};
        //排序后的数组顺序为
        for (int res : a) {
            System.out.print(" " + res);
        }
    }

    /**
     * 比如Arrays工具类提供的排序方法。它内部实现也是快速排序
     * @param a
     */
    private static void arraysSort(int[] a){
        Arrays.sort(a);
    }


    /**
     * 还有就是将数组转为list,使用集合的排序方法,但是这无异于兜圈子,因为集合底层也是数组
     * @param a
     */
    private static void listSort(int[] a){
        List<Integer> integers = Ints.asList(a);
        Collections.sort(integers);
        integers.toArray(new Integer[a.length]);
    }


    /**
     * 选择排序
     */
    public void selectionSort(int[] arr) {
        int len = arr.length;
        int  minIndex, temp;
        for (int  i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int  j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {     // 寻找最小的数
                    minIndex = j;                 // 将最小数的索引保存
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * 选择排序
     */
    public static void selectSort(int[] a){

        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }


    /**
     * 冒泡排序
     */
    public static void sortSimple(int[] a){
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 终极版冒泡排序
     * 加入一个布尔变量,如果内循环没有交换值,说明已经排序完成,提前终止
     * @param arr
     */
    public static void sortPlus(int[] arr){
        if(arr != null && arr.length > 1){
            for(int i = 0; i < arr.length - 1; i++){
                // 初始化一个布尔值
                boolean flag = true;
                for(int j = 0; j < arr.length - i - 1 ; j++){
                    if(arr[j] > arr[j+1]){
                        // 调换
                        int temp;
                        temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        // 改变flag
                        flag = false;
                    }
                }
                if(flag){
                    break;
                }
            }
        }
    }

}
