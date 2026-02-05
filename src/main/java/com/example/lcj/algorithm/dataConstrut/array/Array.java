package com.example.lcj.algorithm.dataConstrut.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lcj
 * @description：每一个数组元素的位置由数字编号，称为下标或者索引(index)。大多数编程语言的数组第一个元素的下
 *                                                                标是 0。
 * @date ：Created in 2020/10/5 10:31
 */
public class Array {
    public static void main(String[] args) {
        // ---------------------------1--------------------
        // int arr[] = {12, 13, 1, 10, 34, 1};
        // print2Smallest(arr);

        // ---------------------------2--------------------
        // int arr2[] = {-1,2,-1,3,2};
        // System.out.println(firstNonRepeating(arr2));
        // int arr[] = { 9, 4, 9, 6, 7, 4 };
        // int n = arr.length;
        // System.out.println(firstNonRepeatin2g(arr, n));

        // ---------------------------3--------------------
        // int[] arr1 = {1, 3, 5, 7};
        // int n1 = arr1.length;
        //
        // int[] arr2 = {2, 4, 6, 8};
        // int n2 = arr2.length;
        //
        // int[] arr3 = new int[n1+n2];
        //
        // mergeArrays(arr1, arr2, n1, n2, arr3);
        //
        // System.out.println("Array after merging");
        // for (int i=0; i < n1+n2; i++) {
        // System.out.print(arr3[i] + " ");
        // }

        // ---------------------------4--------------------
        int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        int n = arr.length;
        rearrange(arr, n);
        System.out.println("Array after rearranging: ");
        printArray(arr, n);
    }

    /**
     * An array contains both positive and negative numbers in random order.
     * Rearrange the array elements so that positive and negative numbers are placed alternatively.
     * Number of positive and negative numbers need not be equal.
     * If there are more positive numbers they appear at the end of the array.
     * If there are more negative numbers, they too appear in the end of the array.
     *
     * For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9],
     * then the output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]
     */
    // The main function that rearranges elements of given
    // array. It puts positive elements at even indexes (0,
    // 2, ..) and negative numbers at odd indexes (1, 3, ..).
    static void rearrange(int arr[], int n) {
        // The following few lines are similar to partition
        // process of QuickSort. The idea is to consider 0
        // as pivot and divide the array around it.
        int i = -1, temp = 0;
        for (int j = 0; j < n; j++) {
            if (arr[j] < 0) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Now all positive numbers are at end and negative numbers at
        // the beginning of array. Initialize indexes for starting point
        // of positive and negative numbers to be swapped
        int pos = i + 1, neg = 0;

        // Increment the negative index by 2 and positive index by 1, i.e.,
        // swap every alternate negative number with next positive number
        while (pos < n && neg < pos && arr[neg] < 0) {
            temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            pos++;
            neg += 2;
        }
    }



    /**
     * Given two sorted arrays, the task is to merge them in a sorted manner.
     * Input: arr1[] = { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8}
     * Output: arr3[] = {1, 2, 3, 4, 4, 5, 6, 8}
     * Input: arr1[] = { 5, 8, 9}, arr2[] = {4, 7, 8}
     * Output: arr3[] = {4, 5, 7, 8, 8, 9}
     *
     * @param arr1
     * @param arr2
     * @param n1
     * @param n2
     * @param arr3
     */
    public static void mergeArrays(int[] arr1, int[] arr2, int n1,
            int n2, int[] arr3) {
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }

        while (i < n1) {
            arr3[k++] = arr1[i++];
        }

        while (j < n2) {
            arr3[k++] = arr2[j++];
        }
    }

    /**
     * Find the first non-repeating element in a given array of integers.
     * Input : -1 2 -1 3 2
     * Output : 3
     * Explanation : The first number that does not
     * repeat is : 3
     *
     * Input : 9 4 9 6 7 4
     * Output : 6
     *
     * @param arr
     */

    /**
     * A Simple Solution is to use two loops.
     * The outer loop picks elements one by one and
     * inner loop checks if the element is present more than once or not.
     *
     * @param arr
     */
    public static int firstNonRepeating(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j;
            for (j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) break;

            }
            if (j == arr.length) {
                return arr[i];
            }
        }
        return -1;
    }

    /**
     * An Efficient Solution is to use hashing.
     * 1) Traverse array and insert elements and their counts in hash table.
     * 2) Traverse array again and print first element with count equals to 1.
     *
     * @param arr
     * @param n
     * @return
     */
    static int firstNonRepeatin2g(int arr[], int n) {
        // Insert all array elements in hash
        // table

        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (m.containsKey(arr[i])) {
                m.put(arr[i], m.get(arr[i]) + 1);
            } else {
                m.put(arr[i], 1);
            }
        }
        // Traverse array again and return
        // first element with count 1.
        for (int i = 0; i < n; i++)
            if (m.get(arr[i]) == 1)
                return arr[i];

        // Traverse through map only and
        // using for-each loop for iteration over Map.entrySet()
        // for (Map.Entry<Integer, Integer> x : m.entrySet())
        // if (x.getValue() == 1)
        // System.out.print(x.getKey() + " ");
        return -1;
    }

    /**
     * Find the smallest and second smallest elements in an array
     * Input: arr[] = {12, 13, 1, 10, 34, 1}
     * Output: The smallest element is 1 and
     * second Smallest element is 10
     *
     * @param arr
     */
    public static void print2Smallest(int[] arr) {
        int first, second, arr_size = arr.length;

        /* There should be atleast two elements */
        if (arr_size < 2) {
            System.out.println(" Invalid Input ");
            return;
        }

        first = second = Integer.MAX_VALUE;
        for (int i = 0; i < arr_size; i++) {
            /*
             * If current element is smaller than first
             * then update both first and second
             */
            if (arr[i] < first) {
                second = first;
                first = arr[i];
            }

            /*
             * If arr[i] is in between first and second
             * then update second
             */
            else if (arr[i] < second && arr[i] != first)
                second = arr[i];
        }
        if (second == Integer.MAX_VALUE)
            System.out.println("There is no second" +
                    "smallest element");
        else
            System.out.println("The smallest element is " +
                    first + " and second Smallest" +
                    " element is " + second);
    }

    // A utility function to print an array
    static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + "   ");
    }
}
