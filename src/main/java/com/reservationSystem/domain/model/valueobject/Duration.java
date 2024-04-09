package com.reservationSystem.domain.model.valueobject;

public record Duration(Integer value) implements IntegerValueObject {
    public static Duration of(Integer value) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("Invalid duration");
        }
        return new Duration(value);
    }

    // IntegerValueObjectインターフェースの実装
    @Override
    public Integer value() {
        return value;
    }
}