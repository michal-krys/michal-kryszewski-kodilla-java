package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public static String beautify(String poem, PoemDecorator poemDecorator){
        System.out.println(poemDecorator.decorate(poem));
        return poemDecorator.decorate(poem);
    }
}
