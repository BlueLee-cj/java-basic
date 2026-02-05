package com.example.lcj.jdk8NewSyntax.lambda;

import java.io.IOException;

/**
 * @author lichengjian
 * @date 2021/2/6
 */
public class LambdaB {
    public static void main(String[] args) throws IOException {
        FunctionB b = (a) -> {
            if(false) {
                throw new IOException("");
            }
            return a + 1;
        };
        System.out.println(b.add(2));
    }
}

interface FunctionB {
    int add(int b) throws IOException;

    default int sub(int c) {
        return c + 4;
    }
}
