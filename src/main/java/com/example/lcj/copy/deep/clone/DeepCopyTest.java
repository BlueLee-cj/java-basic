package com.example.lcj.copy.deep.clone;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.Test;


/**
 * @author lichengjian
 * @date 2021/12/16
 */
public class DeepCopyTest {
    @Test
    public void constructorCopy() throws CloneNotSupportedException {

        Address address = new Address("杭州", "中国");
        User user = new User("大山", address);

        // 调用clone()方法进行深拷贝
        User copyUser = user.clone();

        // 修改源对象的值
        user.getAddress().setCity("深圳");

        // 检查两个对象的值不同
        assertSame(user.getAddress().getCity(), copyUser.getAddress().getCity());
    }

}
