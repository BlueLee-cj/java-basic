package com.example.lcj.jdk8NewSyntax.Stream.demo;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.beust.jcommander.internal.Lists;

import lombok.Data;
import lombok.NoArgsConstructor;

public class HelloWorld {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        List<User> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User u = new User(i, "用户-" + i);
            u.setSon(new Son(10 - i, "用户-儿子" + i));
            list.add(u);
        }
        // 按id从大到小排序
        List<User> sortUser =
                list.stream().sorted((u1, u2) -> u2.getSon().getId().compareTo(u1.getSon().getId()))
                        .collect(Collectors.toList());

        List<User> sortUser1 =
                list.stream().sorted((u1, u2) -> u2.getId().compareTo(u1.getId()))
                        .collect(Collectors.toList());



        // List<User> list1 = list.stream().map(user -> {
        // if (user.getId() == 1) {
        // user.setName("王八蛋");
        // }
        // return user;
        // }).collect(Collectors.toList());

        // list.stream().forEach(user -> {
        // user.setName("ij");
        // testa(user);
        // });

        List<User> collect = list.stream().filter(user -> user.getId() == 1).collect(Collectors.toList());
        System.out.println("排序前：" + list);
        System.out.println("排序后：" + sortUser);
        System.out.println("排序后：" + sortUser1);
        System.out.println("过滤后：" + collect);


        User user = new User();
        user.setId(11);
        user.setName("xioaming");
        user.setSon(new Son(223, "san"));
        System.out.println("最初是：" + user);

        User user1 = new User();
        user1.setId(22);
        user1.setName("xioa2222");
        user1.setSon(user.getSon());
        System.out.println("赋值是：" + user1);

        user.getSon().setName("san222");
        System.out.println("修改是：" + user1);
        System.out.println("修改是：" + user);
        System.out.println("-----------------------------------");



        User use = new User();
        use.setId(1111);
        use.setName("xioaming111");
        use.setSon(new Son(22222, "san2222"));
        use.setSons(Lists.newArrayList(new Son(33, "san3333")));

        User use1 = new User();
        BeanUtils.copyProperties(use, use1);
        System.out.println("被复制：" + use);
        System.out.println("复制后：" + use1);
        System.out.println("复制后：" + use1.getSons().get(0).getName());

        use1.setName("复制后gai");
        use1.getSons().get(0).setName("复制后gai");
        System.out.println("被复制后gai：" + use);
        System.out.println("复制后gai：" + use1);


        System.out.println("-----------------------------------");


        User user2 = new User();
        user2.setId(1111);
        user2.setName("xioaming111");
        user2.setSon(new Son(22222, "san2222"));
        user2.setSons(Lists.newArrayList(new Son(33, "san3333")));

        User user3 = new User();
        BeanUtils.copyProperties(user2, user3);
        System.out.println("被复制：" + user2);
        System.out.println("复制后：" + user3);
        System.out.println("复制后：" + user3.getSons().get(0));

        user3.getSons().get(0).setName("san44444");
        System.out.println("被复制后gai：" + user2);
        System.out.println("复制后gai：" + user3);


    }

    private static void testa(User aa) {
        aa.setName("sdssd");
    }

    @Data
    @NoArgsConstructor
    private static class User {
        Integer id;
        String name;
        Son son;
        List<Son> sons;

        User(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Son getSon() {
            return son;
        }

        public void setSon(Son son) {
            this.son = son;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Son> getSons() {
            return sons;
        }

        public void setSons(List<Son> sons) {
            this.sons = sons;
        }

    }

    @Data
    @NoArgsConstructor
    private static class Userr {
        Integer id;
        String name;
        Sonn son;
        List<Sonn> sons;

        Userr(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Sonn getSon() {
            return son;
        }

        public void setSon(Sonn sonn) {
            this.son = sonn;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Sonn> getSons() {
            return sons;
        }

        public void setSons(List<Sonn> sons) {
            this.sons = sons;
        }

    }

    private static class Son {
        Integer id;
        String name;

        Son(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Son{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    private static class Sonn {
        Integer id;
        String name;

        Sonn(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Sonn{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
