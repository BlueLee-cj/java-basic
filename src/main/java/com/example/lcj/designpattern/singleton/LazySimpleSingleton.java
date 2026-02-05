package com.example.lcj.designpattern.singleton;

/**
 * @author lichengjian
 * @date 2021/3/12
 */
public class LazySimpleSingleton {
    private LazySimpleSingleton() {}

    private static LazySimpleSingleton lazy = null;

    public  static  synchronized LazySimpleSingleton getInstance() {
        if (lazy == null) {
            lazy = new LazySimpleSingleton();
        }
        return lazy;
    }
}
