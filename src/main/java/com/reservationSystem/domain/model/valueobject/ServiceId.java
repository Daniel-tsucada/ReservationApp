package com.reservationSystem.domain.model.valueobject;

public record ServiceId(Integer value) {
    public static ServiceId of(Integer value) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("Invalid service ID");
        }
        return new ServiceId(value);
    }
}
