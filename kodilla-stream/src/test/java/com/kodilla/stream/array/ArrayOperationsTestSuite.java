package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testArrayOperations() {
        //Given
        int[] numbers = {2,3,5,8,11,13,24,45,
                35,46,57,69,13,24,36,56,17,142,84,32};

        //When
        double result = ArrayOperations.getAverage(numbers);

        //Then
        double expectedResult = 36.1;
        assertEquals(expectedResult, result, 0.1);
    }
}

