package com.example.lcj.base;

/**
 * @author ：lcj
 * @description： outer：就相当于表示它现在代表的某个循环。
 * 如果想跳出它所代表的循环，那么就break outer;
 * 如果想结束它所代表的此次循环，那么就continue outer;
 * @modified By：
 * @date ：Created in 2019/8/20 15:13
 */
public class OuterFor {
    public static void main(String[] args) {
        outer:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    System.out.print(j);
                } else {
//                    break outer;
//                    break;
                    continue outer;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("i=" + i + ", j=" + j);
            }
        }

        //在外层循环处添加outer标签
        outer:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //设置outer的判断条件
                if (i == 1) {
                    break outer;
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }
        System.out.println("----------------------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //不要outer，仅仅用break
                if (i == 1) {
                    break;
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }
    }
}
