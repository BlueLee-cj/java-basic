package com.example.lcj.spring.bean.BeanPostProcessor;

import groovy.lang.MetaClassImpl;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
public class IndexService implements BeanNameAware, InitializingBean {

    private BeanPostLuBanService luBanService;

    public void setLuBanService(BeanPostLuBanService luBanService) {
        System.out.println("indexservice populate luBanService");
        this.luBanService = luBanService;
    }

    public IndexService(){
        System.out.println("create instance indexservice");
    }

    @Override
    public String toString() {
        return "IndexService{" +
            "luBanService=" + luBanService +
            '}';
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("IndexService BeanNameAware setBeanName");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("IndexService InitializingBean afterPropertiesSet");
    }

    public void init() {
        System.out.println("IndexService init-method");
    }

    public void print() {
        System.out.println("IndexService print");
    }
}