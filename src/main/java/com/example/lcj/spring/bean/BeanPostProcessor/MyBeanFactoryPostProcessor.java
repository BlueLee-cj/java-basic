package com.example.lcj.spring.bean.BeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/23 14:57
 */
@Component("MyBeanFactoryPostProcessor02")
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        GenericBeanDefinition a = (GenericBeanDefinition) beanFactory.getBeanDefinition("indexService");
        // 打印indexService 的注入模型
        System.out.println("indexService mode=" + a.getAutowireMode());
        a.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
        System.out.println("indexService mode=" + a.getAutowireMode());
    }
}

