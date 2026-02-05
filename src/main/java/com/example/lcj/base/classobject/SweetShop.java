package com.example.lcj.base.classobject;

/**
 * @author lichengjian
 * @date 2024/1/7
 */
public class SweetShop {
    public static void main(String[] args) throws ClassNotFoundException {
        new Candy();
        Class.forName("com.example.lcj.base.classobject.Gum");
        new Cooki();
    }
}
