package com.udemy.springbootweb.section14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertClassTest {

    @Test
    void test() {
        Assertions.assertEquals(1, 1);

        Assertions.assertArrayEquals(new int[] {1,2}, new int[] {2,1}, "Not Correct");

        Assertions.assertTrue(true);
    }
}
