package com.example.lcj.algorithm.T01_Sort;

import java.util.Arrays;

/**
 * @author ：lcj
 * @description：计数排序
 * @date ：Created in 2020/6/1 9:35
 */
public class T07_CountSort {
    public static void main(String[] args) {
        int[] arr = {7,2,5,7,9,2,3,8,1,1};
        print(sort(arr));
    }

    public static int[] sort(int[] arr){
        int[] result = new int[arr.length];
        int[] count = new int[10];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        print(count);
        for (int i=0,j=0; i < count.length; i++){
            while(count[i]-- > 0) result[j++] = i;
        }
        return result;
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
