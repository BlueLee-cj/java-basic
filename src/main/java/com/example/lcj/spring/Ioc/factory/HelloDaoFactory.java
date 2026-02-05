package com.example.lcj.spring.Ioc.factory;

import com.example.lcj.proxy.jdkproxy.HelloWorld;
import com.example.lcj.spring.Ioc.dao.HelloDao;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/1/5 16:47
 */
public class HelloDaoFactory {
    public HelloDaoFactory() {
    }

    public static HelloDao getHelloDao(String daoType) {
        HelloDao helloDao = null;
        if ("dao".equalsIgnoreCase(daoType)) {
            //helloDao = new HelloDaoImpl();
            //HelloWorld helloWorld = new HelloWorld();
        }
        return null;
    }
}
