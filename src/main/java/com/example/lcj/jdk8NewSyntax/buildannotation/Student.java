package com.example.lcj.jdk8NewSyntax.buildannotation;

import lombok.Builder;

@Builder
public class Student {
    // 该字段有一个默认值；
    @Builder.Default
    private int status = 1;
}
