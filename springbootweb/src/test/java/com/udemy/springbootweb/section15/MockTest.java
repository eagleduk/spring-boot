package com.udemy.springbootweb.section15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MockTest {

    @Mock
    DataService dataService;

    @InjectMocks
    UnitTestLogicServiceImpl u;

    @Test
    void getMaxValueTest() {

        DataService mock = Mockito.mock(DataService.class);
        Mockito.when(mock.dataset()).thenReturn(new int[] { 15, 55, 22, 21});

        UnitTestLogicServiceImpl u = new UnitTestLogicServiceImpl(mock);
        int result = u.getMaxValue();

        Assertions.assertEquals(55, result);

    }

    @Test
    void getMaxValueTest_Annotations() {

        Mockito.when(dataService.dataset()).thenReturn(new int[] { 15, 55, 22, 21});
        int result = u.getMaxValue();

        Assertions.assertEquals(55, result);

    }

    @Test
    void listTest() {
        List<String> list = Mockito.mock(List.class);
        Mockito.when(list.get(0)).thenReturn("first call").thenReturn("not first call");
        Assertions.assertEquals("first call", list.get(0));
        Assertions.assertEquals("not first call", list.get(0));
    }

    @Test
    void listParameterTest() {
        List<String> list = Mockito.mock(List.class);
        Mockito.when(list.get(Mockito.anyInt())).thenReturn("any index value");
        Assertions.assertEquals("any index value", list.get(0));
        Assertions.assertEquals("any index value", list.get(10));
    }
}
