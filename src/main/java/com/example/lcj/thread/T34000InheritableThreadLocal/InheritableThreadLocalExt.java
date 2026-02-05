package com.example.lcj.thread.T34000InheritableThreadLocal;

import java.util.Date;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/12/12 22:16
 */
public class InheritableThreadLocalExt extends InheritableThreadLocal {
    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }
}
