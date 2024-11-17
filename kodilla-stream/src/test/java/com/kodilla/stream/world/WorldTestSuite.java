package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        Country poland = new Country("Poland", new BigDecimal("38796099"));
        Country unitedKingdom = new Country("United Kingdom", new BigDecimal("62908832"));
        Country germany = new Country("Germany", new BigDecimal("55432890"));
        Country italy = new Country("Italy", new BigDecimal("31098372"));
        Country usa = new Country("USA" , new BigDecimal("132098768"));
        Country canada = new Country("Canada", new BigDecimal("42132138"));
        Country china = new Country("China", new BigDecimal("1932738467"));
        Country india = new Country("India", new BigDecimal("1298478276"));
        Country japan = new Country("Japan", new BigDecimal("78356728"));
        Country morocco = new Country("Morocco", new BigDecimal("52934760"));
        Country algeria = new Country("Algeria", new BigDecimal("41379648"));
        Country egypt = new Country("Egypt", new BigDecimal("58179373"));

        Continent europe = new Continent("Europe");
        Continent america = new Continent("America");
        Continent asia = new Continent("Asia");
        Continent africa = new Continent("Africa");

        europe.addCountry(poland);
        europe.addCountry(unitedKingdom);
        europe.addCountry(germany);
        europe.addCountry(italy);
        america.addCountry(usa);
        america.addCountry(canada);
        asia.addCountry(china);
        asia.addCountry(india);
        asia.addCountry(japan);
        africa.addCountry(morocco);
        africa.addCountry(algeria);
        africa.addCountry(egypt);

        World theWorld = new World();
        theWorld.addContinent(europe);
        theWorld.addContinent(america);
        theWorld.addContinent(asia);

        //When
        BigDecimal totalPeople = theWorld.getPeopleQuantity();

        //Then
        BigDecimal expectedPeople = new BigDecimal("3672040570");
        assertEquals(expectedPeople, totalPeople);

    }
}