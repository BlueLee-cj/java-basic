package com.example.lcj.interceptor;

import com.alibaba.fastjson.JSON;
import com.example.lcj.interceptor.demo01.ServerResponse;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/29 9:01
 */
@Slf4j
public class ResponseWrite {
    public static void writeResult(HttpServletResponse response, ServerResponse serverResponse)  {
        try {
            response.reset();
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(JSON.toJSONString(serverResponse));
        } catch (Exception e) {
            log.error("");
        }
    }
}
