package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class CollectionTestSuite {

    @BeforeEach
    public void before() {System.out.println("Test case: begin");}
    @AfterEach
    public void after() {System.out.println("Test case: end");}

    @DisplayName("When using exterminator on emptyList " +
            "the result list should return an empty list.")
    @Test
    void testCaseOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> emptyList = new ArrayList<>();
        //When
        List<Integer> result = exterminator.exterminate(emptyList);
        System.out.println("Testing exterminator emptyList");
        //Then
        assertTrue(result.isEmpty());
    }

    @DisplayName("When using exterminator on a list " +
    "the result list should return only even numbers.")
    @Test
    void testCaseOddNumbersExterminatorNormalList() {
//      //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> testList = Arrays.asList(10,11,7,4,8,12,3,53,26,14,76,43,61);
//      //When
        List<Integer> result = exterminator.exterminate(testList);
        System.out.println("Testing exterminator on testList");
//      //Then
        assertTrue(result.stream().allMatch(num -> num % 2 == 0));
    }
}
