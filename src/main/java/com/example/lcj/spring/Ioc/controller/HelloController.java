package com.example.lcj.spring.Ioc.controller;

import com.example.lcj.spring.Ioc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloController {
    @Autowired
    private HelloService service1;
    @Autowired
    private HelloService service2;
    //public void setHelloService(HelloService service2) {
    //    this.service1 = service2;
    //}
    //public HelloController(HelloService helloService){
    //    this.helloService = helloService;
    //}

    public void sayHello(String word) {
        service2.sayHello(word);
    }
}