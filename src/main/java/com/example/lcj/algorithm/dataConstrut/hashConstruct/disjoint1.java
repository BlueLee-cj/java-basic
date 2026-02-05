package com.example.lcj.algorithm.dataConstrut.hashConstruct;// Java program to check if two sets are disjoint

import java.util.Arrays;
import java.util.HashSet;

/*
How to check if two given sets are disjoint?
Last Updated: 22-09-2020
Given two sets represented by two arrays,
how to check if the given two sets are disjoint or not?
 It may be assumed that the given arrays have no duplicates.


Input: set1[] = {12, 34, 11, 9, 3}
       set2[] = {2, 1, 3, 5}
Output: Not Disjoint
3 is common in two sets.

Input: set1[] = {12, 34, 11, 9, 3}
       set2[] = {7, 2, 1, 5}
Output: Yes, Disjoint
There is no common element in two sets.

 */
public class disjoint1 {
    // Driver program to Test above function
    public static void main(String[] args) {
        disjoint1 dis = new disjoint1();
        int[] set1 = {12, 34, 11, 9, 3};
        int[] set2 = {7, 2, 1, 5};

        boolean result = dis.aredisjoint(set1, set2);
        if (result)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    // Returns true if set1[] and set2[] are
    // disjoint, else false
    boolean aredisjoint(int[] set1, int[] set2) {
        // Take every element of set1[] and
        // search it in set2
        for (int i = 0; i < set1.length; i++) {
            for (int j = 0; j < set2.length; j++) {
                if (set1[i] == set2[j])
                    return false;
            }
        }
        // If no element of set1 is present in set2
        return true;
    }

    /*
    Method 2 (Use Sorting and Merging)
        1) Sort first and second sets.
        2) Use merge like the process to compare elements.
        Following is the implementation of the above idea.
     */

    // Returns true if set1[] and set2[] are
    // disjoint, else false
    boolean aredisjoint2(int set1[], int set2[])
    {
        int i=0,j=0;

        // Sort the given two sets
        Arrays.sort(set1);
        Arrays.sort(set2);

        // Check for same elements using
        // merge like process
        while(i<set1.length && j<set2.length)
        {
            if(set1[i]<set2[j])
                i++;
            else if(set1[i]>set2[j])
                j++;
            else
                return false;

        }
        return true;
    }

    // This function prints all distinct elements
    static boolean areDisjoint3(int set1[], int set2[])
    {
        // Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();

        // Traverse the first set and store its elements in hash
        for (int i=0; i<set1.length; i++)
            set.add(set1[i]);

        // Traverse the second set and check if any element of it
        // is already in hash or not.
        for (int i=0; i<set2.length; i++)
            if (set.contains(set2[i]))
                return false;

        return true;
    }
}

// This code is contributed by Rishabh Mahrsee 
