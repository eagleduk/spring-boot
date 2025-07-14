package com.udemy.springbootweb.section15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StubTest {

    @Test
    public void getMaxValueTest() {
        StubData sd = new StubData();
        UnitTestLogicServiceImpl s = new UnitTestLogicServiceImpl(sd);
        int result = s.getMaxValue();
        Assertions.assertEquals(55, result);
    }

    @Test
    public void getMaxValueTest_dataset2() {
        DataService sd = new StubData2();
        UnitTestLogicServiceImpl s = new UnitTestLogicServiceImpl(sd);
        int result = s.getMaxValue();
        Assertions.assertEquals(55, result);
    }
}

class StubData implements DataService {

    @Override
    public int[] dataset() {
        return new int[] { 15, 55, 22, 21};
    }
}

class StubData2 implements DataService {

    @Override
    public int[] dataset() {
        return new int[] { 15};
    }
}

