package com.example.lcj.interceptor.demo02;

public class Main {
    public static void main(String[] args) {
        // Spring MVC会根据请求返回一个HandlerExecutionChain对象
        // 然后执行HandlerExecutionChain的applyPreHandle方法，controller中的方法
        HandlerExecutionChain chain = new HandlerExecutionChain();
        chain.addInterceptor(new CostInterceptor());
        chain.addInterceptor(new LoginInterceptor());
        // 只有拦截器都返回true，才会调用controller的方法
        // CostInterceptor 执行了
        // LoginInterceptor 执行了
        if (!chain.applyPreHandle()) {
            return;
        }
        result();
    }

    public static void result() {
        System.out.println("这是controller的方法");
    }
}