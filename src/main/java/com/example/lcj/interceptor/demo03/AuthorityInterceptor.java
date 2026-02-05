package com.example.lcj.interceptor.demo03;

import com.example.lcj.interceptor.ResponseWrite;
import com.example.lcj.interceptor.demo01.ServerResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/29 8:55
 */
@Component
public class AuthorityInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        Authority authority = method.getAnnotation(Authority.class);
        if (authority == null) {
            return true;
        }
        String userInfo = (String) request.getAttribute("userInfo");
        if (userInfo == null) {
            ServerResponse serverResponse = new ServerResponse(ServerResponse.GlobalStatus.ERROR, "未登录");
            ResponseWrite.writeResult(response,serverResponse);
        }
        int id = authority.id();
        return true;
    }
}
