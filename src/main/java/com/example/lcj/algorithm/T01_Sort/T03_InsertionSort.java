package com.example.lcj.algorithm.T01_Sort;

/**
 * @author ：lcj
 * @description：插入排序
 * @date ：Created in 2020/6/1 9:35
 */
public class T03_InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3,2,5,1,7,6,4,9,8};
        insertSort(arr);
        print(arr);
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
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
