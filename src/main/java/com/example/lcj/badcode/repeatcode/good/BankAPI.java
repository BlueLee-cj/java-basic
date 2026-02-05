package com.example.lcj.badcode.repeatcode.good;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)

@Target(ElementType.TYPE)

@Documented

@Inherited

public @interface BankAPI {

    String desc() default "";

    String url() default "";

}
