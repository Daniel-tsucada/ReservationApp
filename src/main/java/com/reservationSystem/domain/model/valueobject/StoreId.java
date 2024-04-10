package com.reservationSystem.domain.model.valueobject;

public record StoreId(Integer value) {
    public static StoreId of(Integer value) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("Invalid store ID");
        }
        return new StoreId(value);
    }
}