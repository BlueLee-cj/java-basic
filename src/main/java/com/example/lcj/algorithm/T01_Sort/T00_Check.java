package com.example.lcj.algorithm.T01_Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ：lcj
 * @description：选择排序验证
 * @date ：Created in 2020/6/1 9:35
 */
public class T00_Check {
    public static void main(String[] args) {
        check();
    }

    public static int[] generateRandomArray(){
        int[] arr = new int[10000];
        Random random = new Random();

        for (int i = 0; i < arr.length -1; i++) {
            arr[i] = random.nextInt(10000);
        }
        return arr;
    }
    public static void check(){
        int[] arr = generateRandomArray();
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr,0,arr2,0,arr.length);
        Arrays.sort(arr);
        //T01_SelectSort.selectSort(arr2);
        //T02_BubbleSort.bubbleSort(arr2);
        //T04_ShellSort.shellSort(arr2);
        //T05_MergeSort_02.sort(arr2,0,arr2.length-1);
        T06_QuickSort_01.sort(arr2,0,arr2.length-1);
        boolean same = true;
        for (int i = 0; i < arr2.length; i++) {
            if (arr[i] != arr2[i]) same = false;
        }
        System.out.print(same == true ? "right" : "wrong");
    }
}
