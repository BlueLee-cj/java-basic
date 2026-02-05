package com.example.lcj.proxy.interceptor;

public interface Interceptor {
    public boolean before(Object proxy, Object target, Object[] args);

    public void around(Object proxy, Object target, Object[] args);

    public void after(Object proxy, Object target, Object[] args);
}
