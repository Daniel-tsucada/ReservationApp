package com.reservationSystem.domain.model.valueobject;

public record SaleId(Integer value) implements IntegerValueObject {
    public static SaleId of(Integer value) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("Invalid sale ID");
        }
        return new SaleId(value);
    }

    @Override
    public Integer value() {
        return value;
    }
}
