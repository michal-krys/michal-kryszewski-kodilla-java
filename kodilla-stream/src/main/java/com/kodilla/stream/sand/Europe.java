package com.kodilla.stream.sand;

import java.math.BigDecimal;

public final class Europe implements SandStorage {

    @Override
    public BigDecimal getSandBeansQuantity() {
        BigDecimal sandQuantity = new BigDecimal("1374961769182740197491");
        return sandQuantity;
    }
}
