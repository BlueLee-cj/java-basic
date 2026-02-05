package com.example.lcj.enumexample;

/**
 * enum和class、interface的地位一样
 * 使用enum定义的枚举类默认继承了java.lang.Enum，而不是继承Object类。枚举类可以实现一个或多个接口。
 * 枚举类的所有实例都必须放在第一行展示，不需使用new 关键字，不需显式调用构造器。自动添加public static final修饰。
 * 使用enum定义、非抽象的枚举类默认使用final修饰，不可以被继承。
 * 枚举类的构造器只能是私有的。
 */
public enum SeasonEnum {
    SPRING("春天"), SUMMER("夏天"), FALL("秋天"), WINTER("冬天");

    private final String name;

    SeasonEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
