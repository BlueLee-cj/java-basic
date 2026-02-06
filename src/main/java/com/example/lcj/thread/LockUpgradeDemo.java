package com.example.lcj.thread;

import org.openjdk.jol.info.ClassLayout;

/**
 * 锁升级验证：无锁 → 偏向锁 → 轻量级锁 → 重量级锁
 * 
 * 运行参数（重要！）：
 * -XX:BiasedLockingStartupDelay=0  关闭偏向锁延迟（默认 4 秒）
 * -XX:+UseBiasedLocking            开启偏向锁（JDK 15 前默认开启）
 * 
 * JDK 15+ 默认禁用偏向锁，需要加 -XX:+UseBiasedLocking
 */
public class LockUpgradeDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 锁升级验证 ===\n");
        
        // 1. 无锁状态
        testNoLock();
        
        // 2. 偏向锁
        testBiasedLock();
        
        // 3. 轻量级锁
        testLightweightLock();
        
        // 4. 重量级锁
        testHeavyweightLock();
    }

    /**
     * 1. 无锁状态
     * 对象刚创建，没有任何线程访问
     */
    static void testNoLock() {
        System.out.println("========== 1. 无锁状态 ==========");
        Object obj = new Object();
        
        String layout = ClassLayout.parseInstance(obj).toPrintable();
        System.out.println(layout);
        
        // 解读：看第一行 VALUE
        // 01 00 00 00 → 反转后 00 00 00 01
        // 最后 3 位：001 → biased=0, lock=01 → 无锁
        System.out.println("解读：lock=01, biased=0 → 无锁状态\n");
    }

    /**
     * 2. 偏向锁
     * 只有一个线程反复进入同步块
     * 
     * 注意：需要 JVM 参数 -XX:BiasedLockingStartupDelay=0
     */
    static void testBiasedLock() throws InterruptedException {
        System.out.println("========== 2. 偏向锁 ==========");
        
        // 等待偏向锁延迟结束（如果没加 JVM 参数）
        // Thread.sleep(5000);
        
        Object obj = new Object();
        
        System.out.println("加锁前：");
        printMarkWord(obj);
        
        synchronized (obj) {
            System.out.println("加锁后（偏向锁）：");
            printMarkWord(obj);
            // 解读：如果是偏向锁
            // 最后 3 位：101 → biased=1, lock=01 → 偏向锁
            // 前面的位存储了线程 ID
        }
        
        System.out.println("解锁后（偏向锁不会释放）：");
        printMarkWord(obj);
        
        // 同一线程再次进入，直接使用偏向锁，无需 CAS
        synchronized (obj) {
            System.out.println("同一线程再次加锁（直接进入，无需 CAS）：");
            printMarkWord(obj);
        }
        
        System.out.println();
    }

    /**
     * 3. 轻量级锁
     * 两个线程交替执行（不同时竞争）
     */
    static void testLightweightLock() throws InterruptedException {
        System.out.println("========== 3. 轻量级锁 ==========");
        
        Object obj = new Object();
        
        // 先让主线程获取偏向锁
        synchronized (obj) {
            System.out.println("主线程持有锁：");
            printMarkWord(obj);
        }
        
        // 另一个线程尝试获取锁 → 偏向锁撤销 → 升级为轻量级锁
        Thread t = new Thread(() -> {
            synchronized (obj) {
                System.out.println("另一个线程持有锁（偏向锁撤销，升级为轻量级锁）：");
                printMarkWord(obj);
                // 解读：lock=00 → 轻量级锁
            }
        });
        
        t.start();
        t.join();
        
        System.out.println();
    }

    /**
     * 4. 重量级锁
     * 多个线程同时竞争
     */
    static void testHeavyweightLock() throws InterruptedException {
        System.out.println("========== 4. 重量级锁 ==========");
        
        Object obj = new Object();
        
        // 线程 1：持有锁 2 秒
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                System.out.println("线程1 持有锁：");
                printMarkWord(obj);
                try {
                    Thread.sleep(2000);  // 持有锁 2 秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        // 线程 2：尝试获取锁，会自旋等待
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(100);  // 确保 t1 先获取锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.println("线程2 尝试获取锁（会自旋/阻塞）...");
            synchronized (obj) {
                System.out.println("线程2 获取到锁（可能已升级为重量级锁）：");
                printMarkWord(obj);
                // 解读：lock=10 → 重量级锁
            }
        });
        
        // 线程 3：增加竞争
        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            synchronized (obj) {
                System.out.println("线程3 获取到锁：");
                printMarkWord(obj);
            }
        });
        
        t1.start();
        t2.start();
        t3.start();
        
        t1.join();
        t2.join();
        t3.join();
        
        System.out.println();
    }

    /**
     * 打印 Mark Word 并解读锁状态
     */
    static void printMarkWord(Object obj) {
        String layout = ClassLayout.parseInstance(obj).toPrintable();
        
        // 只打印前 5 行
        String[] lines = layout.split("\n");
        for (int i = 0; i < Math.min(5, lines.length); i++) {
            System.out.println(lines[i]);
        }
        
        // 从 JOL 输出中提取锁状态
        // 新版 JOL 格式：0x0000000000000001 (non-biasable; age: 0)
        // 或：0x0000000307ca8188 (thin lock: ...)
        // 或：0x00007fc78c81a23a (fat lock: ...)
        for (String line : lines) {
            if (line.contains("object header: mark") || line.contains("object header)")) {
                if (line.contains("non-biasable")) {
                    System.out.println(">>> 锁状态: 无锁 (non-biasable, 不可偏向)");
                } else if (line.contains("biasable") && !line.contains("biased:")) {
                    // biasable 但没有 biased: 表示"可偏向但还没偏向"，是无锁状态
                    System.out.println(">>> 锁状态: 无锁 (biasable, 可偏向但未偏向)");
                } else if (line.contains("biased:")) {
                    // biased: 后面有 ThreadId，表示已经偏向某个线程
                    System.out.println(">>> 锁状态: 偏向锁 (biased, 已偏向某线程)");
                } else if (line.contains("thin lock")) {
                    System.out.println(">>> 锁状态: 轻量级锁 (thin lock)");
                } else if (line.contains("fat lock")) {
                    System.out.println(">>> 锁状态: 重量级锁 (fat lock)");
                } else {
                    // 尝试从十六进制值解析
                    interpretFromHex(line);
                }
                break;
            }
        }
        System.out.println();
    }
    
    /**
     * 从十六进制值解析锁状态
     */
    static void interpretFromHex(String line) {
        try {
            int start = line.indexOf("0x");
            if (start == -1) return;
            
            int end = start + 2;
            while (end < line.length() && 
                   (Character.isDigit(line.charAt(end)) || 
                    (line.charAt(end) >= 'a' && line.charAt(end) <= 'f'))) {
                end++;
            }
            
            String hexStr = line.substring(start + 2, end);
            long value = Long.parseUnsignedLong(hexStr, 16);
            
            int lock = (int)(value & 0b11);
            int biased = (int)((value >> 2) & 0b1);
            
            String state;
            if (lock == 0b01) {
                state = biased == 1 ? "偏向锁 (lock=01, biased=1)" : "无锁 (lock=01, biased=0)";
            } else if (lock == 0b00) {
                state = "轻量级锁 (lock=00)";
            } else if (lock == 0b10) {
                state = "重量级锁 (lock=10)";
            } else {
                state = "GC 标记 (lock=11)";
            }
            System.out.println(">>> 锁状态: " + state);
        } catch (Exception e) {
            // 解析失败，忽略
        }
    }

    /**
     * 解读锁状态
     */
    static void interpretLockState(String hexByte) {
        try {
            int value = Integer.parseInt(hexByte, 16);
            int lock = value & 0b11;        // 最后 2 位
            int biased = (value >> 2) & 0b1; // 第 3 位
            
            String state;
            if (lock == 0b01) {
                if (biased == 0) {
                    state = "无锁 (lock=01, biased=0)";
                } else {
                    state = "偏向锁 (lock=01, biased=1)";
                }
            } else if (lock == 0b00) {
                state = "轻量级锁 (lock=00)";
            } else if (lock == 0b10) {
                state = "重量级锁 (lock=10)";
            } else {
                state = "GC 标记 (lock=11)";
            }
            
            System.out.println(">>> 锁状态: " + state);
        } catch (Exception e) {
            // 解析失败，忽略
        }
    }
}
