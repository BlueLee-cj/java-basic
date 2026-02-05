package com.example.lcj.spring.bean.InstantiatingBeans.method02Construct;

public class SpringAction {
    //注入对象springDao 
    private SpringDao springDao;
    private User user;

    public SpringAction(SpringDao springDao, User user) {
        this.springDao = springDao;
        this.user = user;
        System.out.println("构造方法调用springDao和user");
    }

    public String save() {
        user.setName("卡卡");
        return springDao.ok();
    }
} 
