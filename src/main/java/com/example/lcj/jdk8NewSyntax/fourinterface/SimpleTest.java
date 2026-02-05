package com.example.lcj.jdk8NewSyntax.fourinterface;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;


/**
 * @author lichengjian
 * @date 2021/1/14
 */
public class SimpleTest {
    public static void main(String[] args) {
        // consumer
        consumeTask(10, m -> System.out.println(m));

        // predicate
        List<String> strings = Arrays.asList("a", "b", "c");
        System.out.println(strPredicate(strings, m -> !m.equals("b")));

        // supplier
        Supplier<Student> studentSupplier = () -> new Student("lcj", 20);
        System.out.println(studentSupplier.get());
        Supplier<Student> studentSupplier1 = Student::new;
        System.out.println(studentSupplier1.get().getAge());

        // function
        System.out.println(strHandler("aaa", (str) -> str.toUpperCase()));

        
        Map<String, Supplier<String>> iconMap = new HashMap<String, Supplier<String>>() {
            {
                put("a", () -> "aa");
                put("b", () -> "bb");
            }
        };

        // 1
        Supplier<String> a = () -> "aa";
        Supplier<String> b = () -> "bb";
        Map<String, Supplier<String>> iconMap2 = new HashMap<String, Supplier<String>>();
        iconMap2.put("a", a);
        iconMap2.put("b", b);
        
        // 2
        iconMap2.put("a", () -> "aa");
        iconMap2.put("b", () -> "bb");
        
        // 3
        Map<String, Supplier<String>> iconMap3 = new HashMap<String, Supplier<String>>(){
            @Override
            public Supplier<String> put(String key, Supplier<String> value) {
                return super.put(key, value);
            }
        };

        Map<String, Supplier<String>> iconMap4 = new HashMap<String, Supplier<String>>(){
            {
                put("a", () -> "aa");
                put("b", () -> "bb");
            }
        };
        
        Supplier<String> supplier = iconMap.get("a");
        if (supplier != null) {
            System.out.println(supplier.get());
        }
    }

    public static void consumeTask(int num, Consumer<Integer> consumer) {
        consumer.accept(num);
    }


    public static String strHandler(String str, Function<String, String> function) {
        return function.apply(str);
    }

    public static List<String> strPredicate(List<String> list, Predicate<String> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    /**
     * @author lichengjian
     * @date 2021/1/14
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Student {
        private String name;
        private int age;
    }
}
