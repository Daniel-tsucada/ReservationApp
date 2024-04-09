package com.reservationSystem.domain.model.valueobject;

public record Phone(String value) implements StringValueObject {
    public Phone {
        if (value == null || !value.matches("^\\+?[0-9. ()-]{7,20}$")) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
    }

    public static Phone of(String value) {
        return new Phone(value);
    }

    @Override
    public String value() {
        return value;
    }
}