package com.example.lcj.interceptor.demo01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/29 8:41
 */
@Slf4j
public class SystemInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("request-starttime", System.currentTimeMillis());
        log.info("request enter:{}", request.getRequestURI());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Long starttime = (Long) request.getAttribute("request-starttime");
        if (starttime != null) {
            long cost = System.currentTimeMillis() - starttime;
            log.info("{} request {} cost:{}",request.getRequestURI(),request.getQueryString(),cost );
        }
        super.afterCompletion(request, response, handler, ex);
    }
}
