package com.example.lcj.algorithm.dataConstrut.hashConstruct;// Java program to find whether an array
// is subset of another array 
/*
Find whether an array is subset of another array | Added Method 3
Last Updated: 26-07-2019
Given two arrays: arr1[0..m-1] and arr2[0..n-1].
Find whether arr2[] is a subset of arr1[] or not.
Both the arrays are not in sorted order. It may be assumed that elements in both array are distinct.
Examples:

Input: arr1[] = {11, 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1}
Output: arr2[] is a subset of arr1[]

Input: arr1[] = {1, 2, 3, 4, 5, 6}, arr2[] = {1, 2, 4}
Output: arr2[] is a subset of arr1[]

Input: arr1[] = {10, 5, 2, 23, 19}, arr2[] = {19, 5, 3}
Output: arr2[] is not a subset of arr1[]
 */
class GFG {

    /* Return true if arr2[] is a subset
    of arr1[] */
    /*
    Use two loops: The outer loop picks all the elements of arr2[] one by one.
    The inner loop linearly searches for the element picked by the outer loop.
    If all elements are found then return 1, else return 0.
     */
    static boolean isSubset(int[] arr1,
                            int[] arr2, int m, int n) {
        int i = 0;
        int j = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++)
                if (arr2[i] == arr1[j])
                    break;
			
			/* If the above inner loop 
			was not broken at all then 
			arr2[i] is not present in 
			arr1[] */
            if (j == m)
                return false;
        }
		
		/* If we reach here then all 
		elements of arr2[] are present 
		in arr1[] */
        return true;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr1 = {11, 1, 13, 21, 3, 7};
        int[] arr2 = {11, 3, 7, 1};

        int m = arr1.length;
        int n = arr2.length;

        if (isSubset(arr1, arr2, m, n))
            System.out.print("arr2[] is "
                    + "subset of arr1[] ");
        else
            System.out.print("arr2[] is "
                    + "not a subset of arr1[]");
    }
} 
