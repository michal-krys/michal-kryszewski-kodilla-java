package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public static String beautify(String poem, PoemDecorator poemDecorator){
        String result = poemDecorator.decorate();
        return result;
    }
}
