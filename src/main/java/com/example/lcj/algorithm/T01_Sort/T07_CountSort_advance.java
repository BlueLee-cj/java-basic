package com.example.lcj.algorithm.T01_Sort;

/**
 * @author ：lcj
 * @description：计数排序_保证稳定
 * @date ：Created in 2020/6/1 9:35
 */
public class T07_CountSort_advance {
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
        for (int i = 1; i < arr.length; i++) {
            count[i] = count[i] + count[i-1];
        }
        print(count);
        for (int i=arr.length-1; i >= 0; i--){
            result[--count[arr[i]]] = arr[i];
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
