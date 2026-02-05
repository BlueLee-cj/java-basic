package com.example.lcj.cookie2session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping("login")
    public String login(HttpSession session, @RequestParam("username") String
            username) {
        session.setAttribute("username", username);
        return "success";
    }

    @RequestMapping("shoppingcar")
    public String showProduct(HttpSession session) {
        String usename = (String) session.getAttribute("username");
        return "username is " + usename;
    }

    @RequestMapping("login1")
    public String login(HttpServletRequest request, @RequestParam("username")
            String username) {
        request.setAttribute("username", username);
        return "success";
    }

    @RequestMapping("shoppingcar1")
    public String showProduct(HttpServletRequest request) {
        String usename = (String) request.getAttribute("username");
        return "username is " + usename;
    }
}