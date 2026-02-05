package com.example.lcj.algorithm.T01_Sort;

/**
 * @author ：lcj
 * @description：合并排序
 * @date ：Created in 2020/6/1 9:35
 */
public class T05_MergeSort_01_First {
    public static void main(String[] args) {
        int[] arr = {1,2,5,7,14,11,12,13};
        mergeSort(arr);

    }

    public static int[] mergeSort(int[] arr) {
        int mid = arr.length/2;
        int[] temp = new int[arr.length];

        int i = 0;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j < arr.length){
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }

        while(i <= mid) temp[k++] = arr[i++];
        while(j < arr.length) temp[k++] = arr[j++];

        print(temp);
        return temp;
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
