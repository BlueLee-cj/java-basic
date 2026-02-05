package com.example.lcj.algorithm.T01_Sort;

/**
 * @author ：lcj
 * @description：不稳定
 * @date ：Created in 2020/6/1 15:02
 */
public class T01_SelectSort_Unsafe {
    public static void main(String[] args) {
        selectSort();
    }
    public static void selectSort(){
        int b[][] = {{1,8}, {2,2}, {3,8}, {4,1}}; // 从小到大选择排序
        int n = b.length;
        for(int i=0;i<n-1; i++){// i为已排序序列的末尾
            int min = i;//标记
            for(int j=i+1;j<n;j++){
                if(b[j][1] < b[min][1]){//后一个数与前面一个数比较，找出最小值
                    min = j;
                }
            }
            if(min != i){// 放到已排序序列的末尾，该操作很有可能把稳定性打乱，所以选择排序是不稳定的排序算法
                int temp = b[min][1];
                b[min][1] = b[i][1];
                b[i][1] = temp;
            }
        }
        for(int i=0;i<n;i++){
            System.out.print("{" + b[i][0] + "," + b[i][1] + "},  ");
        }
    }
}
