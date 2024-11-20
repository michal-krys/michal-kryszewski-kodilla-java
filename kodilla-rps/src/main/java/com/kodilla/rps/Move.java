package com.kodilla.rps;

public class Move {

    private String name;
    private int reference;

    public Move(String name, int reference) {
        this.name = name;
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public int getReference() {
        return reference;
    }

    public boolean beats(Move other) {
        return (this.reference == 1 && other.reference == 3) ||
                (this.reference == 2 && other.reference == 1) ||
                (this.reference == 3 && other.reference == 2);
    }
}
