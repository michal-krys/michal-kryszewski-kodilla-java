package com.kodilla.stream.sand;

import java.math.BigDecimal;

public final class Africa implements SandStorage{

    @Override
    public BigDecimal getSandBeansQuantity() {
        BigDecimal sandQuantity = new BigDecimal("999995716491865918274810924810");
        return sandQuantity;
    }
}
