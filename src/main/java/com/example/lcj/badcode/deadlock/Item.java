package com.example.lcj.badcode.deadlock;

import java.util.concurrent.locks.ReentrantLock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    String name; // 商品名

    int remaining = 1000; // 库存剩余

    ReentrantLock lock = new ReentrantLock();
}
