package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderWithoutHandling;

public class ExceptionModuleRunner {
    public static void main(String[] args) throws FileReaderException {
        FileReader fileReader = new FileReader();
        String fileName = "nams.txt";

        try {
            fileReader.readFile(fileName);
        } catch (Exception e) {
            System.out.println("Problem with reading the file");
        }
    }
}
