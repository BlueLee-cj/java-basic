package com.example.lcj.spring.bean.create;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.lcj.spring.bean.create")
public class Config {
    @Bean
    public CreateService service(){
        return new CreateService();
    }
}

