package com.example.lcj.springannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ：lcj
 * @description：可以看出，使用构造器注入的方法，可以明确成员变量的加载顺序。 　　PS：Java变量的初始化顺序为：静态变量或静态语句块–>实例变量或初始化语句块–>构造方法–>@Autowired
 * 　　那么最开始Spring建议，为何要将成员变量加上final类型呢？
 * @date ：Created in 2020/3/12 14:48
 */
@Component
public class UserAccountServiceImpl {
    //@Autowired
    private User user;
    private String school;


    public UserAccountServiceImpl(User user) {
        this.school = user.getSchool();
    }
}
