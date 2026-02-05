package com.example.lcj.base.variableparam;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/3 17:23
 */
public class ArgsTest {
    public static void listUsers(Object ... args) {
        System.out.println(args.length);
    }
        public static void main(String[] args) {
            listUsers ( 1 , 2 , 3 );
            listUsers(new int [] { 1 , 2 , 3 }) ;
            listUsers ( 3 , new String[] {"1" ,"2"});
            listUsers (new Integer [] { 1 , 2 , 3 } ) ;
            listUsers( 3 , new Integer[] { 1 , 2 , 3 });
    }
}
