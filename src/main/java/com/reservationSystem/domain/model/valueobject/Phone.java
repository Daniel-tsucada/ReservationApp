package com.reservationSystem.domain.model.valueobject;

public record Phone(String value) {
    public static Phone of(String value) {
        if (value == null || !value.matches("^\\+?[0-9. ()-]{7,20}$")) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
        return new Phone(value);
    }
}