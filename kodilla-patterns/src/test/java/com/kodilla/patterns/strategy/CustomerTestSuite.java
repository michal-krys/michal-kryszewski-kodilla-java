package com.kodilla.patterns.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTestSuite {

    @Test
    void testDefaultInvestingStrategies() {
        //given
        Customer steven = new IndividualCustomer("Steven Links");
        Customer john = new IndividualYoungCustomer("John Hemerald");
        Customer kodilla = new CorporateCustomer("Kodilla");

        //when
        String stevenShouldBuy = steven.predict();
        System.out.println("Steven should: " + stevenShouldBuy);
        String johnShouldBuy = john.predict();
        System.out.println("John should: " + johnShouldBuy);
        String kodillaShouldBuy = kodilla.predict();
        System.out.println("Kodilla should: " + kodillaShouldBuy);

        //then
        assertEquals("[Conservative predictor] Buy debentures of XYZ", stevenShouldBuy);
        assertEquals("[Aggressive predictor] Buy stock of XYZ", johnShouldBuy);
        assertEquals("[Moderate predictor] Buy shared units of Fund XYZ", kodillaShouldBuy);
    }

    @Test
    void testIndividualInvestingStrategy() {
        //given
        Customer steven = new IndividualCustomer("Steven Links");

        //when
        String stevenShouldBuy = steven.predict();
        System.out.println("Steven should: " + stevenShouldBuy);
        steven.setBuyingStrategy(new AggressivePredictor());
        stevenShouldBuy = steven.predict();
        System.out.println("Steven now should: " + stevenShouldBuy);

        //then
        assertEquals("[Aggressive predictor] Buy stock of XYZ", stevenShouldBuy);
    }
}
