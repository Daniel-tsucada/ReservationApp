package com.reservationSystem.domain.model.valueobject;

import com.fasterxml.jackson.annotation.JsonValue;

public record Duration(Integer value) implements ValueObject<Integer> {
    public static Duration of(Integer value) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("Invalid duration");
        }
        return new Duration(value);
    }
}