package com.example.lcj.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
// @Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
// @Repeatable(value = Anos.class)
public @interface Ano {
    String getValue() default "no desc";
}
