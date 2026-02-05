package com.example.lcj.jdk8NewSyntax.Stream.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lichengjian
 * @date 2021/2/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private Trader trader;
    private int year;
    private int value;
}
