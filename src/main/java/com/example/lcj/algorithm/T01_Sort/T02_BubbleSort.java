package com.example.lcj.algorithm.T01_Sort;

/**
 * @author ：lcj
 * @description：选择排序
 * @date ：Created in 2020/6/1 9:35
 */
public class T02_BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,2,5,1,7,6,4,9,8};
        bubbleSort(arr);
        print(arr);
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length-1; i >0; i--) {
           findMax(arr,i);
        }
    }

    static void findMax(int[] arr, int n){
        for (int j = 0; j < n; j++) {
            if(arr[j] > arr[j+1]){
                swap(arr,j,j+1);
            }
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
