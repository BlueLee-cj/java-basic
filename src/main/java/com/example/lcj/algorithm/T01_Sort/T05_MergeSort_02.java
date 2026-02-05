package com.example.lcj.algorithm.T01_Sort;

/**
 * @author ：lcj
 * @description：合并排序
 * @date ：Created in 2020/6/1 9:35
 */
public class T05_MergeSort_02 {
    public static void main(String[] args) {
        int[] arr = {1,2,5,7,14,13,12,11};
        sort(arr,0,arr.length-1);
    }

    public static void sort(int[] arr, int left, int right){
        //递归终止
        if(left == right) return;
        //分两半
        int mid = left + (right - left)/2;
        //左边排序
        sort(arr,left,mid);
        //右边排序
        sort(arr,mid+1,right);
        //合并
        merge(arr,left,mid+1, right);
    }

    public static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound) {
        int mid = rightPtr - 1;
        //新数据储存
        int[] temp = new int[rightBound - leftPtr + 1];

        int i = leftPtr;
        int j = rightPtr;
        int k = 0;

        while(i <= mid && j <= rightBound){
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while(i <= mid) temp[k++] = arr[i++];
        while(j <= rightBound) temp[k++] = arr[j++];

        //复制
        for (int m = 0; m < temp.length; m++) {
            arr[leftPtr + m] = temp[m];
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
