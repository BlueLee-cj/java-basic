package com.example.lcj.base.copy;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.beust.jcommander.internal.Lists;

import lombok.Data;
import lombok.NoArgsConstructor;

public class HelloWorld {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        User use = new User();
        use.setId(1111);
        use.setName("xioaming111");
        use.setSon(new Son(22222, "san2222"));
        use.setSons(Lists.newArrayList(new Son(33, "san3333")));

        Userr use1 = new Userr();
        BeanUtils.copyProperties(use, use1);
        System.out.println("被复制：" + use);
        System.out.println("复制后：" + use1);
        // System.out.println("复制后：" + use1.getSons().get(0).getName());

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
        // System.out.println("复制后：" + user3.getSons().get(0));

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
        int id;
        String name;
        Sonn son;
        ArrayList<Sonn> sons;

        Userr(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Sonn getSon() {
            return son;
        }

        public void setSon(Sonn sonn) {
            this.son = sonn;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ArrayList<Sonn> getSons() {
            return sons;
        }

        public void setSons(ArrayList<Sonn> sons) {
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
