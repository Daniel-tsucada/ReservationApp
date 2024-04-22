package com.reservationSystem.domain.model.valueobject;

import com.fasterxml.jackson.annotation.JsonValue;

public record ReservationId(@JsonValue Integer value) {
    public static ReservationId of(Integer value) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("Invalid reservation ID");
        }
        return new ReservationId(value);
    }
}
