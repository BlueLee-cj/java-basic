package com.example.lcj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JavaBasicApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JavaBasicApplication.class, args);

        // 添加一个关闭钩子，在应用关闭时执行一些操作
        addShutdownHook(context);
    }

    private static void addShutdownHook(ConfigurableApplicationContext context) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // 在这里执行优雅关闭的逻辑，例如等待正在进行的请求和事务完成
            System.out.println("Shutting down gracefully...");

            // 关闭Spring上下文
            context.close();

            System.out.println("Shutdown complete.");
        }));
    }
}
