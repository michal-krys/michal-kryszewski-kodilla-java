package com.kodilla.good.patterns.challanges;

import java.util.stream.Collectors;

public class MovieStoreRun {

    public static void main(String[] args) {

        MovieStore movieStore = new MovieStore();

        String movies = movieStore.getMovies()
                .values()
                .stream()
                .map(translations -> String.join(": ", translations))
                .collect(Collectors.joining("! "));

        System.out.println(movies);
    }
}
