package com.example.lcj.proxy.mybatisproxy.plugindemo;

import java.util.ArrayList;
import java.util.List;

public class InterceptorChain {
    /**
     * 放拦截器
     */
    private final List<Interceptor> interceptors = new ArrayList<Interceptor>();

    public Object pluginAll(Object target) {
        for (Interceptor interceptor : interceptors) {
            target = interceptor.plugin(target);
        }
        return target;
    }

    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }
}
