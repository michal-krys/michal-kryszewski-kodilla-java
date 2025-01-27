package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {
        //given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("Brioche")
                .burgers(3)
                .sauce("Bourbon Chipotle")
                .ingredient("Lettuce")
                .ingredient("Red Onion")
                .ingredient("Butter Dill Pickle")
                .ingredient("Colby Jack Cheese")
                .ingredient("Maple Glazed Bacon")
                .build();
        System.out.println(bigmac);
        //when
        int howManyIng = bigmac.getIngredients().size();
        int howManBurgers = bigmac.getBurgers();
        String bun = bigmac.getBun();
        String sauce = bigmac.getSauce();
        //then
        assertEquals(5, howManyIng);
        assertEquals(3, howManBurgers);
        assertEquals("Brioche", bun);
        assertEquals("Bourbon Chipotle", sauce);
    }
}
