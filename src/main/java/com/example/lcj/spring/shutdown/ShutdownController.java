package com.example.lcj.spring.shutdown;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShutdownController {

    @GetMapping("/shutdown")
    public String test() throws InterruptedException {
        Thread.sleep(10000);
        return "ok";
    }
}
