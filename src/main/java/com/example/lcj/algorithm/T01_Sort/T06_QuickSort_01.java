package com.example.lcj.algorithm.T01_Sort;

import java.util.Arrays;

/**
 * @author ：lcj
 * @description：快速排序
 * @date ：Created in 2020/6/1 9:35
 */
public class T06_QuickSort_01 {
    public static void main(String[] args) {
        int[] arr = {8,7,2,5,7,9,2,3,8};
        sort(arr,0,arr.length-1);
        print(arr);
    }

    public static void sort(int[] arr, int leftBound, int rightBound){
        if(leftBound >= rightBound) return;
        int mid = partion(arr, leftBound, rightBound);
        sort(arr,leftBound,mid-1);
        sort(arr,mid+1,rightBound);
    }

    public static int partion(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;

        while(left <= right){
            while(left <= right && arr[left] <= pivot) left ++;
            while(left <= right && arr[right] > pivot) right --;
            if(left < right) swap(arr,left,right);
        }
        swap(arr,left,rightBound);
        return left;
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
