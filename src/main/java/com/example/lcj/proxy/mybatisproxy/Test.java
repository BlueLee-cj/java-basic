package com.example.lcj.proxy.mybatisproxy;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/11/14 9:18
 */
public class Test {
    public static void main(String[] args) {
        MapperProxy proxy = new MapperProxy();

        UserMapper mapper = proxy.newInstance(UserMapper.class);
        User user = mapper.getUserById(1001);

        System.out.println("ID:" + user.getId());
        System.out.println("Name:" + user.getName());
        System.out.println("Age:" + user.getAge());

        System.out.println(mapper.toString());
    }
}
