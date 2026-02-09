package com.example.lcj.jvm;

/**
 * JIT 编译优化 - 逃逸分析演示
 *
 * 逃逸分析 (Escape Analysis) 是 JIT 编译器的一种优化技术，
 * 用于分析对象的动态作用域，判断对象是否会"逃逸"出方法或线程。
 *
 * 启用/禁用逃逸分析的 JVM 参数：
 * -XX:+DoEscapeAnalysis   开启逃逸分析（JDK 8+ 默认开启）
 * -XX:-DoEscapeAnalysis   关闭逃逸分析
 * -XX:+PrintEscapeAnalysis 打印逃逸分析结果（debug 版 JVM）
 *
 * 运行对比测试：
 * # 开启逃逸分析（默认）
 * java -Xms100m -Xmx100m -XX:+DoEscapeAnalysis -XX:+PrintGC EscapeAnalysisDemo
 *
 * # 关闭逃逸分析
 * java -Xms100m -Xmx100m -XX:-DoEscapeAnalysis -XX:+PrintGC EscapeAnalysisDemo
 */
public class EscapeAnalysisDemo {

    /**
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │                         逃逸分析的三种状态                               │
     * ├─────────────────────────────────────────────────────────────────────────┤
     * │                                                                         │
     * │  1. 不逃逸 (NoEscape)                                                   │
     * │     - 对象只在方法内部使用，不会被外部访问                              │
     * │     - 可以进行栈上分配、标量替换                                        │
     * │                                                                         │
     * │  2. 方法逃逸 (ArgEscape)                                                │
     * │     - 对象作为参数传递给其他方法，但不会被其他线程访问                  │
     * │     - 可以进行锁消除优化                                                │
     * │                                                                         │
     * │  3. 线程逃逸 (GlobalEscape)                                             │
     * │     - 对象被其他线程访问（如赋值给静态变量、存入集合等）                │
     * │     - 无法进行逃逸分析优化                                              │
     * │                                                                         │
     * └─────────────────────────────────────────────────────────────────────────┘
     */

    // ======================== 1. 不逃逸示例 ========================

    /**
     * 对象不逃逸 - 可以进行栈上分配
     * Point 对象只在方法内部使用，方法结束后即可回收
     */
    public int noEscape() {
        Point p = new Point(1, 2);  // 对象不逃逸，可能被栈上分配
        return p.x + p.y;
    }

    /**
     * 标量替换优化示例
     * JIT 可能将上面的代码优化为：
     *
     * public int noEscape_optimized() {
     *     int x = 1;  // 标量替换：对象被拆解为基本类型
     *     int y = 2;
     *     return x + y;
     * }
     */

    // ======================== 2. 方法逃逸示例 ========================

    /**
     * 对象发生方法逃逸 - 作为返回值返回
     */
    public Point methodEscape() {
        Point p = new Point(1, 2);
        return p;  // 对象逃逸到方法外部，必须在堆上分配
    }

    /**
     * 对象发生方法逃逸 - 作为参数传递
     */
    public void methodEscape2() {
        Point p = new Point(1, 2);
        print(p);  // 对象作为参数传递，发生方法逃逸
    }

    private void print(Point p) {
        System.out.println(p.x + ", " + p.y);
    }

    // ======================== 3. 线程逃逸示例 ========================

    private static Point globalPoint;

    /**
     * 对象发生线程逃逸 - 赋值给静态变量
     */
    public void threadEscape() {
        Point p = new Point(1, 2);
        globalPoint = p;  // 对象可能被其他线程访问，发生线程逃逸
    }

    // ======================== 基于逃逸分析的优化 ========================

    /**
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │                      基于逃逸分析的三种优化                              │
     * ├─────────────────────────────────────────────────────────────────────────┤
     * │                                                                         │
     * │  优化类型        条件              效果                                 │
     * │  ─────────────────────────────────────────────────────────────────────  │
     * │  栈上分配        对象不逃逸        对象在栈上分配，方法结束自动回收      │
     * │  (Stack Alloc)                     避免 GC 压力                         │
     * │                                                                         │
     * │  标量替换        对象不逃逸        将对象拆解为基本类型变量              │
     * │  (Scalar Replace)                  完全消除对象分配                     │
     * │                                                                         │
     * │  锁消除          对象不逃逸        移除不必要的同步锁                    │
     * │  (Lock Elision)                    消除同步开销                         │
     * │                                                                         │
     * └─────────────────────────────────────────────────────────────────────────┘
     */

    // -------- 优化1: 栈上分配 --------

    /**
     * 栈上分配演示
     * 开启逃逸分析时，大量循环创建的对象可能在栈上分配，减少 GC
     */
    public static void stackAllocation() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100_000_000; i++) {
            allocate();  // 对象不逃逸，可能栈上分配
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start) + " ms");
    }

    private static void allocate() {
        Point p = new Point(1, 2);  // 不逃逸的对象
    }

    // -------- 优化2: 标量替换 --------

    /**
     * 标量替换演示
     * 标量：不可再分的基本类型（int, long, reference 等）
     * 聚合量：可以继续分解的对象
     *
     * JVM 参数：
     * -XX:+EliminateAllocations  开启标量替换（默认开启）
     * -XX:-EliminateAllocations  关闭标量替换
     */
    public int scalarReplace() {
        Point p = new Point(10, 20);
        // JIT 优化后可能变成：
        // int x = 10;
        // int y = 20;
        // return x + y;
        return p.x + p.y;
    }

    // -------- 优化3: 锁消除 --------

    /**
     * 锁消除演示
     * 如果对象不会逃逸到其他线程，则同步锁可以被消除
     *
     * JVM 参数：
     * -XX:+EliminateLocks  开启锁消除（默认开启）
     * -XX:-EliminateLocks  关闭锁消除
     */
    public void lockElimination() {
        // StringBuffer 是线程安全的，内部有 synchronized
        // 但 sb 对象不会逃逸，所以锁可以被消除
        StringBuffer sb = new StringBuffer();
        sb.append("a");
        sb.append("b");
        sb.append("c");
        // JIT 优化后，synchronized 锁会被消除
    }

    /**
     * 同步块锁消除示例
     */
    public void lockElimination2() {
        Object lock = new Object();  // lock 对象不逃逸
        synchronized (lock) {        // 这个锁会被消除
            System.out.println("hello");
        }
    }

    // ======================== 测试类 ========================

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // ======================== 性能对比测试 ========================

    public static void main(String[] args) {
        System.out.println("=== 逃逸分析性能测试 ===");
        System.out.println("JVM 参数建议：");
        System.out.println("  开启: -XX:+DoEscapeAnalysis -XX:+EliminateAllocations");
        System.out.println("  关闭: -XX:-DoEscapeAnalysis");
        System.out.println();

        // 预热 JIT
        for (int i = 0; i < 10; i++) {
            stackAllocation();
        }

        System.out.println("\n=== 正式测试 ===");
        stackAllocation();

        // 打印 GC 信息
        System.out.println("\n内存使用情况：");
        Runtime runtime = Runtime.getRuntime();
        System.out.println("最大内存: " + runtime.maxMemory() / 1024 / 1024 + " MB");
        System.out.println("已分配内存: " + runtime.totalMemory() / 1024 / 1024 + " MB");
        System.out.println("空闲内存: " + runtime.freeMemory() / 1024 / 1024 + " MB");
    }
}

/**
 * ┌─────────────────────────────────────────────────────────────────────────────┐
 * │                              总结                                           │
 * ├─────────────────────────────────────────────────────────────────────────────┤
 * │                                                                             │
 * │  逃逸分析是 JIT 编译器的重要优化技术：                                      │
 * │                                                                             │
 * │  1. 分析对象作用域，判断是否逃逸                                            │
 * │  2. 对不逃逸的对象进行优化：                                                │
 * │     - 栈上分配：减少 GC 压力                                                │
 * │     - 标量替换：消除对象分配                                                │
 * │     - 锁消除：移除不必要的同步                                              │
 * │                                                                             │
 * │  注意事项：                                                                 │
 * │  - 逃逸分析本身有开销，只对热点代码生效                                     │
 * │  - HotSpot 目前不支持真正的栈上分配，主要通过标量替换实现类似效果           │
 * │  - 开发时不必刻意为逃逸分析编码，JIT 会自动优化                             │
 * │                                                                             │
 * └─────────────────────────────────────────────────────────────────────────────┘
 */
