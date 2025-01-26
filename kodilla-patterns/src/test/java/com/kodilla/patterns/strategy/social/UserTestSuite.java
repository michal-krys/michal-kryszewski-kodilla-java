package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //given
        User john = new Millenials("John");
        User donald = new YGeneration("Donald");
        User jenny = new ZGeneration("Jenny");
        //when
        String johnPublished = john.publish();
        String donaldPublished = donald.publish();
        String jennyPublished = jenny.publish();
        //then
        assertEquals("Facebook", johnPublished);
        assertEquals("Twitter", donaldPublished);
        assertEquals("Snapchat!", jennyPublished);
    }

    @Test
    void testIndividualSharingStrategies() {
        //given
        User john = new Millenials("John");
        //when
        String johnPublished = john.publish();
        System.out.println("John published on " + johnPublished);
        john.setSocialPublisher(new SnapchatPublisher());
        johnPublished = john.publish();
        //then
        assertEquals("Snapchat!", johnPublished);
        assertNotEquals("Facebook", johnPublished);
    }
}
