package com.kodilla.testing;
import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;


public class TestingMain {
public static void main(String[] args) {

    //Calculator test
       Calculator calculator = new Calculator();

       int resultAdd = calculator.add(8,4);
       int resultSubt = calculator.subtract(5,6);

       if (resultAdd == 12 && resultSubt == -1) {
           System.out.println("Test finished successfully");
        } else {
           System.out.println("Test failed");
        }
    }
}
