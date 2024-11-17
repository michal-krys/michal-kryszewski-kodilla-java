package com.kodilla.stream.sand;

import java.math.BigDecimal;

public final class Asia implements SandStorage{

    @Override
    public BigDecimal getSandBeansQuantity() {
        BigDecimal sandQuantity = new BigDecimal("99999904179845687162123581562378417");
        return sandQuantity;
    }
}
