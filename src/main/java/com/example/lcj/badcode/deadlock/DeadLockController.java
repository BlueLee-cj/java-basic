package com.example.lcj.badcode.deadlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lichengjian
 * @date 2022/3/6
 */
@RestController
@Slf4j
public class DeadLockController {

    List<Item> items = new ArrayList<Item>();

    private List<Item> createCart() {

        return IntStream.rangeClosed(1, 3)

                .mapToObj(i -> ThreadLocalRandom.current().nextInt(items.size()))

                .map(name -> items.get(name)).collect(Collectors.toList());

    }

    private boolean createOrder(List<Item> order) {

        // 存放所有获得的锁

        List<ReentrantLock> locks = new ArrayList<>();

        for (Item item : order) {

            try {

                // 获得锁10秒超时

                if (item.lock.tryLock(10, TimeUnit.SECONDS)) {

                    locks.add(item.lock);

                } else {

                    locks.forEach(ReentrantLock::unlock);

                    return false;

                }

            } catch (InterruptedException e) {

            }

        }

        // 锁全部拿到之后执行扣减库存业务逻辑

        try {

            order.forEach(item -> item.remaining--);

        } finally {

            locks.forEach(ReentrantLock::unlock);

        }

        return true;

    }

    @SuppressWarnings("checkstyle:WhitespaceAfter")
    @GetMapping("wrong")

    public long wrong() {

        long begin = System.currentTimeMillis();

        // 并发进行100次下单操作，统计成功次数

        long success = IntStream.rangeClosed(1, 100).parallel()

                .mapToObj(i -> {

                    List<Item> cart = createCart();

                    return createOrder(cart);

                })

                .filter(result -> result)

                .count();

        log.info("success:{} totalRemaining:{} took:{}ms items:{}", success,
                items.stream().map(item -> item.remaining).reduce(0, Integer::sum),
                System.currentTimeMillis() - begin, items);

        return success;

    }
}
