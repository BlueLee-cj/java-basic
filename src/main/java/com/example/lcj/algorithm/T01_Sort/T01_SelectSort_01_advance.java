package com.example.lcj.algorithm.T01_Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ：lcj
 * @description：选择排序 * 选择排序
 * * 时间复杂度：O(n²)
 * * 优化：语句；多次使用则分离成方法；
 * * 遍历优化：一轮遍历，找出最大值和最小值
 * @date ：Created in 2020/6/1 9:35
 */
public class T01_SelectSort_01_advance {

    public static void selectSortAdvance(int[] arr) {
        int midPos;
        if(arr.length%2 == 0) {
            midPos = arr.length/2;
        } else {
            midPos = arr.length/2 + 1;
        }
        for (int i = 0; i < midPos; i++) {
            int minPos = i;
            int maxPos = arr.length - 1 - i;
            if (arr[minPos] > arr[maxPos]) {
                int temp = minPos;
                minPos = maxPos;
                maxPos = temp;
            }
            for (int j = i; j < arr.length-1-i; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
                maxPos = arr[j] > arr[maxPos] ? j : maxPos;
            }
            swapValOfArray(arr, i, minPos);
            if (maxPos != i) {//如果最大值不在i位置上，可以直接交换
                swapValOfArray(arr, arr.length - 1 - i, maxPos);
            } else {
                //如果在最大值在i位置，则前面交换后，最大值位置在minPos位置
                // (因为maxPos指定的位置，已经经过交换成为最小值)
                swapValOfArray(arr, arr.length - 1 - i, minPos);
            }
        }
    }


    public static void main(String[] args) {
        //int[] arr2 = {3,2,5,1,1,7,6,4,9,8};
        //method1(arr2);
        //print(arr2);

        int[] arr = newArr(10, 1000);
        System.out.println("原数组内容：");
        print(arr);//遍历方法

        //selectionSort(arr);
        selectSortAdvance(arr);
        System.out.println("排序后数组内容：");
        print(arr);//遍历方法

        int[] arr1 = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr1);//对照组
        print(arr1);

        System.out.println(validate(arr, arr1));

    }

    //验证每个元素是否排好序
    static boolean validate(int[] arr, int[] arr1) {
        boolean isFlag = true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr1[i]) {
                isFlag = false;
                break;//只要有一个元素不对应，即可判断未完全排序好
            }
        }

        return isFlag;

    }

    //随机数组生成器
    static int[] newArr(int length, int range) {
        int[] arr = new int[length];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(range);
        }
        return arr;

    }

    static void selectionSort(int[] arr) {

        int midPos;
        if (arr.length % 2 == 0) {
            midPos = arr.length / 2;
        } else {
            midPos = arr.length / 2 + 1;
        }

        for (int i = 0; i < midPos; i++) {
            int minPos = i;
            int maxPos = arr.length - 1 - i;
            if (arr[minPos] > arr[maxPos]) {
                int temp = minPos;
                minPos = maxPos;
                maxPos = temp;
            }

            for (int j = i + 1; j < arr.length - 1 - i; j++) {
                minPos = arr[minPos] > arr[j] ? j : minPos; //语句优化
                maxPos = arr[maxPos] < arr[j] ? j : maxPos;
            }

            swapValOfArray(arr, i, minPos);//交换两个元素方法

            if (maxPos != i) {//如果最大值不在i位置上，可以直接交换
                swapValOfArray(arr, arr.length - 1 - i, maxPos);
            } else {
                //如果在最大值在i位置，则前面交换后，最大值位置在minPos位置
                // (因为maxPos指定的位置，已经经过交换成为最小值)
                swapValOfArray(arr, arr.length - 1 - i, minPos);
            }
        }
        print(arr);
    }

    static void swapValOfArray(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }


}

