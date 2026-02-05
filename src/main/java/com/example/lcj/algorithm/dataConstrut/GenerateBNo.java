package com.example.lcj.algorithm.dataConstrut;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列将 1 到 n 转换为二进制:
 * Given a number n, write a function that generates and prints all binary numbers with decimal values from 1 to n.
 * Examples:
 *
 * Input: n = 2
 * Output: 1, 10
 *
 * Input: n = 5
 * Output: 1, 10, 11, 100, 101
 1
 10
 11
 100
 101
 110
 111
 1000
 1001
 1010
 */
public class GenerateBNo {
    // This function uses queue data structure to print binary numbers
    /*
    以下是一种有趣的方法，该方法使用队列数据结构来打印二进制数。 感谢Vivek建议这种方法。
        1）创建一个空的字符串队列
        2）使第一个二进制数字“ 1”排队。
        3）现在运行一个循环，以生成和打印n个二进制数。
        ……a）出队并打印队列的前面。
        ……b）在最前面的项目末尾添加“ 0”并将其排队。
        ……c）在最前面的项目末尾添加“ 1”并将其排队。
     */
    static void generatePrintBinary(int n) {
        // Create an empty queue of strings 
        Queue<String> q = new LinkedList<String>();

        // Enqueue the first binary number 
        q.add("1");

        // This loops is like BFS of a tree with 1 as root 
        // 0 as left child and 1 as right child and so on 
        while (n-- > 0) {
            // print the front of queue 
            String s1 = q.peek();
            q.remove();
            System.out.println(s1);

            // Store s1 before changing it 
            String s2 = s1;

            // Append "0" to s1 and enqueue it 
            q.add(s1 + "0");

            // Append "1" to s2 and enqueue it. Note that s2 contains 
            // the previous front 
            q.add(s2 + "1");
        }
    }

    // Driver program to Test above function
    public static void main(String[] args) {
        int n = 10;
        generatePrintBinary(n);
    }
}
//This code is contributed by Sumit Ghosh
