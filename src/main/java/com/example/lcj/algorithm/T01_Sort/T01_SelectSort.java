package com.example.lcj.algorithm.T01_Sort;

/**
 * @author ：lcj
 * @description：选择排序
 * @date ：Created in 2020/6/1 9:35
 */
public class T01_SelectSort {
    public static void main(String[] args) {
        int[] arr = {3,2,5,1,7,6,4,9,8};
        selectSort(arr);
        print(arr);
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int minPos = i;
            for (int j = i+1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            swap(arr,i,minPos);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length -1){
                System.out.println(arr[i] + " ");
            }else{
                System.out.print(arr[i] + " ");
            }
        }
    }
}
