package com.reservationSystem.domain.model.valueobject;

public record StoreId(Integer value) implements IntegerValueObject {
    public static StoreId of(Integer value) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("Invalid store ID");
        }
        return new StoreId(value);
    }

    @Override
    public Integer value() {
        return value;
    }
}