package com.example.lcj.filter.demo01;


public class LogFilter implements Filter {
    @Override
    public void doFilter(FilterChain chain) {
        System.out.println("LogFilter执行了");
        chain.doFilter();
    }
}