package com.example.lcj.reflect.DynamicLoad;

/**
 * 当执行Main.java时，由于用到了Main，因此，JVM首先会把Main.class加载到内存。然而，并不会加载Person.class，
 * 除非程序执行到create()方法，JVM发现需要加载Person类时，才会首次加载Person.class。
 * 如果没有执行create()方法，那么Person.class根本就不会被加载。
 * 这就是JVM动态加载class的特性。
 * JVM为每个加载的class及interface创建了对应的Class实例来保存class及interface的所有信息；
 * 获取一个class对应的Class实例后，就可以获取该class的所有信息；
 * 通过Class实例获取class信息的方法称为反射（Reflection）；
 * JVM总是动态加载class，可以在运行期根据条件来控制加载class。
 */
public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            create(args[0]);
        }
    }

    static void create(String name) {
        Person p = new Person(name);
    }
}