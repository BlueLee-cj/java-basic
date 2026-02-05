package com.example.lcj.base.finaltest;

class MyClass {

    // void changeValue(final StringBuffer buffer) {
    // buffer.append("world");
    // }

    void changeValue(StringBuffer buffer1) {
        // buffer.append("world");
        buffer1 = new StringBuffer("world");
    }
}
