package com.kodilla.exception.test;

public class FFRunner {

    public static void main(String[] args) {

        Flight berlinWarsaw = new Flight("Berlin", "Warsaw");
        Flight portoLondon = new Flight("Porto", "London");
        Flight warsawKiev = new Flight("Warsaw", "Kiev");
        Flight washingtonManchester = new Flight("Washington", "Manchester");

        FlightFinder flightFinder = new FlightFinder();

        try {
            flightFinder.findFlight(warsawKiev);
        } catch (RouteNotFoundException e) {
            System.out.println("Route not found!\n");
        } finally {
            System.out.println("Thank you for using Flight Finder :)");
        }
    }
}
