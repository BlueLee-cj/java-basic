package com.example.lcj.spring.bean.DependencyInjection.ConstructorbasedDependencyInjection.demo02xml;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/23 0:54
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        AbstractBeanDefinition  beanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition("a");
        System.out.println(beanDefinition.getAutowireMode());
        beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
        //beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_CONSTRUCTOR);
    }
}
