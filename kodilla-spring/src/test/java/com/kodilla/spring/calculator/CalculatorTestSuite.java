package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Display display;

    @Test
    void testCalculations() {
        //given
        //when
        display.displayValue(4.09+3.32);
        display.displayValue(7-2.65);
        display.displayValue(5.03*6.22);
        display.displayValue(12.1/5.3);
        //then
    }
}
