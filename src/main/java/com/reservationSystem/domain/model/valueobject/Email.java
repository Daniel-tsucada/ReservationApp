package com.reservationSystem.domain.model.valueobject;

public record Email(String value) implements StringValueObject {
    public static Email of(String value) {
        if (value == null || !value.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        return new Email(value);
    }

    // StringValueObjectインターフェースの実装
    @Override
    public String value() {
        return value;
    }
}
