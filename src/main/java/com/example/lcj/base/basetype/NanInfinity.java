package com.example.lcj.base.basetype;

/**
 * @author lichengjian
 * @date 2024/1/5
 */
public class NanInfinity {

    // Double：

    public static final double POSITIVE_INFINITY = 1.0 / 0.0;

    public static final double NEGATIVE_INFINITY = -1.0 / 0.0;


    // Float：

    public static final float POSITIVE_INFINITY1 = 1.0f / 0.0f;

    public static final float NEGATIVE_INFINITY1 = -1.0f / 0.0f;

    public static void main(String[] args) {
        System.out.println(Float.POSITIVE_INFINITY * 0); // output: NAN

        System.out.println(Float.NEGATIVE_INFINITY * 0); // output: NAN

        System.out.println((Float.POSITIVE_INFINITY / 0) == Float.POSITIVE_INFINITY); // output: true
        System.out.println((Float.NEGATIVE_INFINITY / 0) == Float.NEGATIVE_INFINITY); // output: true


        System.out.println(Float.POSITIVE_INFINITY == (Float.POSITIVE_INFINITY + 10000)); // output: true
        System.out.println(Float.POSITIVE_INFINITY == (Float.POSITIVE_INFINITY - 10000)); // output: true
        System.out.println(Float.POSITIVE_INFINITY == (Float.POSITIVE_INFINITY * 10000)); // output: true
        System.out.println(Float.POSITIVE_INFINITY == (Float.POSITIVE_INFINITY / 10000)); // output: true

        System.out.println(Double.isInfinite(Float.POSITIVE_INFINITY)); // output: true

        System.out.println(Float.NaN == Float.NaN); // output: false
        System.out.println(Double.isNaN(Float.NaN)); // output: true

    }
}
