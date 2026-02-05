package com.example.lcj.jdk8NewSyntax.fourinterface;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * @author lichengjian
 * @date 2021/1/15
 */
public class SupplierTest {
    @Test
    public void test1() {
        Supplier<String> supplier = String::new;
        System.out.println(supplier.get());//""
        Supplier<Emp> supplierEmp = Emp::new;
        Emp emp = supplierEmp.get();
        emp.setName("dd");
        System.out.println(emp.getName());//dd
    }
    public static class Emp {
        private String name;

        public Emp() {

        }

        public Emp(String name) {
            super();
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
