package com.example.lcj.jdk8NewSyntax.buildannotation;


public class TestLombok {
    public static void main(String[] args) {
        testBuilderAnnotation();
    }

    public static void testBuilderAnnotation() {
        UserInfo userInfo = UserInfo.builder()
                .name("zzl")
                .email("bgood@sina.com")
                .build();
        userInfo = userInfo.toBuilder()
                .name("OK")
                .email("zgood@sina.com")
                .build();
        System.out.println(userInfo.getName());
        // 生成的student对象并没有使用status的默认值
        Student student = Student.builder().build();
        //如果想让类中的字段默认值生效，需要使用@Default注解
        //@Builder会生成一个全参的构造函数
        System.out.println(student);
    }

}