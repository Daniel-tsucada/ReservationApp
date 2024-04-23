package com.reservationSystem.domain.model.valueobject;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonValue;

public record Price(@JsonValue BigDecimal value) implements ValueObject<BigDecimal> {
    public static Price of(BigDecimal value) {
        if (value == null || value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid price");
        }
        return new Price(value);
    }
}