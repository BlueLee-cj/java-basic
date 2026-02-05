package com.example.lcj.designpattern.singleton;

/**
 * @author lichengjian
 * @date 2021/3/13
 */
public class ThreadLocalSingletion {
    private static final ThreadLocal<ThreadLocalSingletion> theadLocalInstance =
            new ThreadLocal<ThreadLocalSingletion>() {
                @Override
                protected ThreadLocalSingletion initialValue() {
                    return new ThreadLocalSingletion();
                }
            };

    private ThreadLocalSingletion() {}

    public static ThreadLocalSingletion getInstance() {
        return theadLocalInstance.get();
    }
}
