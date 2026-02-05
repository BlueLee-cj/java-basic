package com.example.lcj.interceptor.demo03;

import com.example.lcj.interceptor.demo01.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/29 8:51
 */
@RestController("usercontroller01")
@Slf4j
public class UserController {
    @Authority
    @RequestMapping("/delete")
    public ServerResponse delete(HttpServletRequest request){
        String  userInfo = (String) request.getAttribute("userInfo");
        log.info("{} delete the user", userInfo);
        return new ServerResponse(ServerResponse.GlobalStatus.SUCCESS,"删除用户");
    }
}
