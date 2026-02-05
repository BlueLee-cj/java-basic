package com.example.lcj.algorithm.T01_Sort;

/**
 * @author ：lcj
 * @description：希尔排序
 * @date ：Created in 2020/6/1 9:35
 */
public class T04_ShellSort {
    public static void main(String[] args) {
        int[] arr = {3,2,5,1,7,6,4,9,8,0};
        shellSort(arr);
        print(arr);
    }


    /**
     * 希尔排序
     *
     * @param array
     * @return
     */
    public static int[] ShellSort1(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    public static void shellSort(int[] arr) {
        for (int gap = arr.length/2; gap > 0; gap /= 2){
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap-1 ; j-=gap) {
                    if(arr[j] < arr[j-gap]){
                        int temp = arr[j];
                        arr[j] = arr[j-gap];
                        arr[j-gap] = temp;
                    }
                }
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
