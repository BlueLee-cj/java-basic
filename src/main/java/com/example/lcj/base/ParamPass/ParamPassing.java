package com.example.lcj.base.ParamPass;

public class ParamPassing {
    private static int intStatic = 222;
    private static String stringStatic = "Old string";
    private static StringBuilder stringBuilderStatic = new StringBuilder("Old stringbulder");

    public static void main(String[] args) {
        method(intStatic);
        method(stringStatic);
        method(stringBuilderStatic, stringBuilderStatic);
        System.out.println(intStatic);
        method();
        System.out.println(intStatic);
        System.out.println(stringStatic);
        System.out.println(stringBuilderStatic);
    }

    public static void method(int intStatic) {
        intStatic = 7777;
    }

    public static void method() {
        intStatic = 888;
    }

    public static void method(String stringStatic) {
        stringStatic = new String("new string");
    }

    public static void method(StringBuilder stringBuilderStatic1, StringBuilder stringBuilderStatic2) {
        stringBuilderStatic1.append(".method.first-");
        stringBuilderStatic2.append("method.second-");
        System.out.println(stringBuilderStatic);
        System.out.println(stringBuilderStatic1);

        stringBuilderStatic1 = new StringBuilder("new StringBuilder");
        stringBuilderStatic1.append("new mehtod's append");
        System.out.println(stringBuilderStatic);
        System.out.println(stringBuilderStatic1);
    }

    /**
     * 在D 方法中， new 出来个新的StringBuilder 对象，赋值给stringBuilderStatic 1 。
     * 注意， 这是一个新的局部引用变量， 使用AS TORE 命令对局部变量表的第一个位
     * 置的引用变量值进行了覆盖， 然后再重新进行ALOAD 到操作枝顶，所以后续对于
     * stringBuilderStatic 1 的append 操作， 与类的静态引用变量stringBuilderStatic 没有任何
     * 关系。
     */
}
