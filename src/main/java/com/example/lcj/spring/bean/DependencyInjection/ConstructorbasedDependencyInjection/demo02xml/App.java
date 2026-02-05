package com.example.lcj.spring.bean.DependencyInjection.ConstructorbasedDependencyInjection.demo02xml;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.Resource;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/22 22:41
 */
@Configuration
@ComponentScan("com.example.lcj.spring.bean.DependencyInjection.ConstructorbasedDependencyInjection.demo02xml")
//@ImportResource("classpath:spring/di/spring.xml")
public class App {
}
