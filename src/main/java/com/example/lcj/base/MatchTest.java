package com.example.lcj.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchTest {
    public static void main(String[] args) {
//		String��ķ�����
        boolean a = "ab1".matches("[a-z]+");
        System.out.println(a);
//		Pattern���еķ�����
        boolean b = Pattern.matches("[a-z]{3}", "abc");
        System.out.println(b);
//		Matcher���еķ�����
        Pattern p = Pattern.compile("[a-z]{3}");
        Matcher m = p.matcher("acc");
        boolean c = m.matches();
        System.out.println(c);
    }
}
