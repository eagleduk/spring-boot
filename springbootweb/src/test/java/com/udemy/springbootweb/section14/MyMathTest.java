package com.udemy.springbootweb.section14;

import org.junit.jupiter.api.*;

public class MyMathTest {

    @Test
    void test2() {
        int[] numbers = {};

        MyMath myMath = new MyMath();
        int result = myMath.calculateSum(numbers);

        Assertions.assertEquals(0, result);
    }

    @Test
    void test() {
        int[] numbers = {1,2,3};

        MyMath myMath = new MyMath();
        int result = myMath.calculateSum(numbers);

        Assertions.assertEquals(6, result);


    }
}
