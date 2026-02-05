package com.example.lcj.jdk8NewSyntax.buildannotation;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class UserInfo {
    private String name;
    private String email;
}