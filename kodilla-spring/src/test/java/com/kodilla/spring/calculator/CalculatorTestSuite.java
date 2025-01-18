package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations() {
        //when
        double val1 = calculator.add(2, 1);
        double val2 = calculator.sub(3,1);
        double val3 = calculator.mul(2,3);
        double val4 = calculator.div(6, 2);
        //then
        assertEquals(3, val1);
        assertEquals(2, val2);
        assertEquals(6, val3);
        assertEquals(3, val4);
    }
}
