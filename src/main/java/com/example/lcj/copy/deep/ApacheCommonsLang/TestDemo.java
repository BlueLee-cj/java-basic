package com.example.lcj.copy.deep.ApacheCommonsLang;

import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import com.example.lcj.copy.Address;
import com.example.lcj.copy.User;

/**
 * @author lichengjian
 * @date 2021/12/16
 */
public class TestDemo {
    @Test
    public void serializableCopy() {

        Address address = new Address("杭州", "中国");
        User user = new User("大山", address);

        // 使用Apache Commons Lang序列化进行深拷贝
        // User copyUser = (User) SerializationUtils.clone(user);
        User copyUser = null;
        // 修改源对象的值
        user.getAddress().setCity("深圳");

        // 检查两个对象的值不同
        assertNotSame(user.getAddress().getCity(), copyUser.getAddress().getCity());

    }

}
