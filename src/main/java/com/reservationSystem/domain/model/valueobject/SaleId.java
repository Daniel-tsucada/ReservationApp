package com.reservationSystem.domain.model.valueobject;

public record SaleId(Integer value) {
    public static SaleId of(Integer value) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("Invalid sale ID");
        }
        return new SaleId(value);
    }

}
