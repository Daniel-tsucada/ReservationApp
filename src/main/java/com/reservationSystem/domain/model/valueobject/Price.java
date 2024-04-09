package com.reservationSystem.domain.model.valueobject;

import java.math.BigDecimal;

public record Price(BigDecimal value) implements BigDecimalValueObject {
    public static Price of(BigDecimal value) {
        if (value == null || value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid price");
        }
        return new Price(value);
    }

    @Override
    public BigDecimal value() {
        return value;
    }
}