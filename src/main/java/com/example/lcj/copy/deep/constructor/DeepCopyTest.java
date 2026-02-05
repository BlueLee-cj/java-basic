package com.example.lcj.copy.deep.constructor;

import com.example.lcj.copy.Address;
import com.example.lcj.copy.User;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;

/**
 * @author lichengjian
 * @date 2021/12/16
 */
public class DeepCopyTest {
    @Test
    public void constructorCopy() {

        Address address = new Address("杭州", "中国");
        User user = new User("大山", address);

        // 调用构造函数时进行深拷贝
        User copyUser = new User(user.getName(), new Address(address.getCity(), address.getCountry()));

        // 修改源对象的值
        user.getAddress().setCity("深圳");

        // 检查两个对象的值不同
        assertNotSame(user.getAddress().getCity(), copyUser.getAddress().getCity());
    }

}
