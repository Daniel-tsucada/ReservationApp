package com.reservationSystem.domain.model.valueobject;

import com.fasterxml.jackson.annotation.JsonValue;

public record CustomerId(@JsonValue Integer value) {
    public static CustomerId of(Integer value) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("Invalid customer ID");
        }
        return new CustomerId(value);
    }

}
