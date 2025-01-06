package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    public void findFlight(Flight flight) throws RouteNotFoundException{

        System.out.println("Welcome to Flight Finder! \n" +
                "Status of your search: \n");

        String departure = flight.getDepartureAirport();
        String arrival = flight.getArrivalAirport();

        Map<String, Boolean> airportSifter = new HashMap<>();

        airportSifter.put("Warsaw", true);
        airportSifter.put("Kiev", false);
        airportSifter.put("Berlin", true);
        airportSifter.put("Oslo", false);
        airportSifter.put("London", true);

        Boolean departureAvailable = airportSifter.get(departure);
        Boolean arrivalAvailable = airportSifter.get(arrival);

        if (departureAvailable != null && arrivalAvailable != null && departureAvailable && arrivalAvailable) {
            System.out.println("Flight from " + departure + " to " + arrival + " found!\n");
        } else {
            throw new RouteNotFoundException("Sorry, flight is not operated on this route.");
        }
    }
}
