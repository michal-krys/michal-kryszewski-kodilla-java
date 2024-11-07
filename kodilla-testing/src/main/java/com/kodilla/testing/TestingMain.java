package com.kodilla.testing;
import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;


public class TestingMain {
public static void main(String[] args) {

    //Calculator test
       Calculator calculator = new Calculator(8, 2);
       Calculator calculator1 = new Calculator(9, 16);

       int resultAdd = calculator.add();
       int resultSubt = calculator1.subtract();

       if (resultAdd == 10 && resultSubt == 10) {
           System.out.println("Test finished successfully");
        } else {
           System.out.println("Test failed");
        }
    }
}
