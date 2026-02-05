package com.example.lcj.base.multitype;

import java.util.Arrays;
import java.util.List;

/**
 * @author lichengjian
 * @date 2024/1/7
 */
public class ShapeTest {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(new Circle(), new Square());
        shapes.forEach(shape -> shape.draw());
        System.out.println(shapes);
    }
}
