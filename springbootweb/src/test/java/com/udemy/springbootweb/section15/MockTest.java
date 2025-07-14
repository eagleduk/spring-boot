package com.udemy.springbootweb.section15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class MockTest {

    @Test
    void getMaxValueTest() {

        DataService mock = Mockito.mock(DataService.class);
        Mockito.when(mock.dataset()).thenReturn(new int[] { 15, 55, 22, 21});

        UnitTestLogicServiceImpl u = new UnitTestLogicServiceImpl(mock);
        int result = u.getMaxValue();

        Assertions.assertEquals(55, result);

    }
}
