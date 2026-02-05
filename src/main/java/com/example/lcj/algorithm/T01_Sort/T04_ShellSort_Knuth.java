package com.example.lcj.algorithm.T01_Sort;

/**
 * @author ：lcj
 * @description：希尔排序
 * @date ：Created in 2020/6/1 9:35
 */
public class T04_ShellSort_Knuth {
    public static void main(String[] args) {
        int[] arr = {3,2,5,1,7,6,4,9,8,112,34,34,22,12,5,3,2,333,55};
        shellSort(arr);
        print(arr);
    }

    public static void shellSort(int[] arr) {
        int h = 1;
        while(h <= arr.length/3){
            h = h*3 + 1;
        }
        for (int gap = h; gap > 0; gap = (gap-1)/3){
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap-1 ; j-=gap) {
                    if(arr[j] < arr[j-gap]){
                        swap(arr,j,j-gap);
                    }
                }
            }
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
