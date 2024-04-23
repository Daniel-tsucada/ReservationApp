package com.reservationSystem.domain.model.valueobject;

import com.fasterxml.jackson.annotation.JsonValue;

public record StoreId(@JsonValue Integer value) implements ValueObject<Integer> {
    public static StoreId of(Integer value) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("Invalid store ID");
        }
        return new StoreId(value);
    }
}