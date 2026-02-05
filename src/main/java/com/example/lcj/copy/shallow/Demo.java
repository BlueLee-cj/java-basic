package com.example.lcj.copy.shallow;

import com.example.lcj.copy.User02;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import com.example.lcj.copy.Address;
import com.example.lcj.copy.User;

import java.io.IOException;

/**
 * @author lichengjian
 * @date 2021/12/16
 */
public class Demo {

    @Test
    public void copy() throws IOException {

        Address address = new Address("杭州", "中国");
        User user = new User("大山", address);

        // 调用构造函数时进行深拷贝
        User02 copyUser = new User02();
        BeanUtils.copyProperties(user, copyUser);

        System.out.println(user);
        System.out.println(copyUser);

        ObjectMapper MAPPER = new ObjectMapper();
        String ss = MAPPER.writeValueAsString(user);
        System.out.println(ss);

        User02 user02 = MAPPER.readValue(ss, User02.class);
        System.out.println(user02);
    }
}
