package com.example.lcj.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author ：lcj
 * @description：数据里有{1,2,3,4,5,6,7,8,9}，请随机打乱顺序，生成一个新的数 组（请以代码实现）
 * @date ：Created in 2020/10/6 10:38
 */
public class RandomSort {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //System.out.println(Arrays.toString(srand(a)));
        List resultList = new ArrayList<>(a.length);
        for (int s : a) {
            resultList.add(s);
        }
        Collections.shuffle(resultList);
        System.out.println(Arrays.toString(resultList.toArray()));
    }

    public static int[] srand(int[] a) {
        int[] b = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            //随机获取下标
            int tmp = (int) (Math.random() * (a.length - i));
            //随机数:[ 0 , a.length - i )
            b[i] = a[tmp];
            //将此时a[tmp]的下标移动到靠后的位置
            int change = a[a.length - i - 1];
            a[a.length - i - 1] = a[tmp];
            a[tmp] = change;
        }
        return b;
    }

    /**
     * 8      * 对给定数目的自0开始步长为1的数字序列进行乱序
     * 9      * @param no 给定数目
     * 10      * @return 乱序后的数组
     * 11
     */
    public static int[] getSequence(int no) {
        int[] sequence = new int[no];
        for (int i = 0; i < no; i++) {
            sequence[i] = i;
        }
        Random random = new Random();
        for (int i = 0; i < no; i++) {
            int p = random.nextInt(no);
            int tmp = sequence[i];
            sequence[i] = sequence[p];
            sequence[p] = tmp;
        }
        random = null;
        return sequence;
    }

}



