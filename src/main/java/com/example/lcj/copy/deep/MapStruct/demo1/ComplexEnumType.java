package com.example.lcj.copy.deep.MapStruct.demo1;

import java.util.Arrays;

import lombok.Getter;

@Getter
public enum ComplexEnumType {
    HAHA(1, "haha"), HEHE(2, "hehe");

    private Integer code;
    private String name;

    ComplexEnumType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static ComplexEnumType getByCode(Integer code) {
        return Arrays.stream(values()).filter(x -> x.getCode().equals(code)).findFirst().orElse(null);
    }
}
