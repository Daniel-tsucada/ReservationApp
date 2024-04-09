package com.reservationSystem.domain.model.valueobject;

import java.math.BigDecimal;

public record Price(BigDecimal value) {
    public static Price of(BigDecimal value) {
        if (value == null || value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid price");
        }
        return new Price(value);
    }
}