package com.reservationSystem.domain.model.valueobject;

import com.fasterxml.jackson.annotation.JsonValue;

public record Phone(String value) implements ValueObject<String> {
    public static Phone of(String value) {
        if (value == null || !value.matches("^\\+?[0-9. ()-]{7,20}$")) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
        return new Phone(value);
    }
}