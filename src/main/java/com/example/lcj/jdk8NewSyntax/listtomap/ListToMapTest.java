package com.example.lcj.jdk8NewSyntax.listtomap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.example.lcj.copy.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lichengjian
 * @date 2022/2/26
 */
public class ListToMapTest {
    public static void main1(String[] args) {
        // groupingBy();

        ArrayList<String> aa = Lists.newArrayList("11", "22");
        ArrayList<String>  bb  = Lists.newArrayList(aa);
        bb.add("33");

        System.out.println(aa);
        System.out.println(bb);
    }

    /**
     * partitioningBy(分割) 和 的作用相识
     * 不同的是他的key值为true/false
     *
     * @return
     */
    public static void groupingBy() {
        List<User> users = Lists.newArrayList();
        users.add(new User("1111", 20));
        users.add(new User("2222", 23));
        users.add(new User("2222", 18));

        users.add(new User("4444", 18));
        HashMap<Integer, List<User>> collect =
                users.stream().collect(Collectors.groupingBy(c -> c.getAge(), HashMap::new, Collectors.toList()));

        Map<Integer, List<String>> collect1 = users.stream()
                .collect(Collectors.groupingBy(c -> c.getAge(),
                        Collectors.mapping(p -> p.getName(), Collectors.toList())));
        System.out.println("xxxx");
    }

    public static void main(String[] args) {
        LiteUser liteUser = new LiteUser();
        liteUser.setUserId("xxx");
        liteUser.setAvatar("xxx");
        liteUser.setUsername("aaa");
        liteUser.setGender("M");
        System.out.println(JSON.toJSON(liteUser));
    }

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LiteUser implements Serializable {
        private static final long serialVersionUID = 3481911284910973337L;
        @JsonProperty("_id")
        private String userId;
        private String id;
        private String username;
        private String gender;
        private String avatar;

        @JsonValue
        public Map<String, Object> toJson() {
            Map<String, Object> model = new HashMap<>();
            model.put("id", id);
            model.put("_id", userId);
            model.put("username", username);
            model.put("userName", username);
            model.put("avatar", avatar);
            model.put("gender", gender);
            return model;
        }
    }
}
