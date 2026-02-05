package com.example.lcj.spring.aop.demo03_log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/test/simple")
@Validated
@Slf4j
public class ValidationController {

    @Log
    @GetMapping("/valid")
    public String testValid(
            @Max(10) int age, @Valid @NotBlank String name) {
        log.info("接口入参：" + age + "      " + name);
        return "OK";
    }
}
