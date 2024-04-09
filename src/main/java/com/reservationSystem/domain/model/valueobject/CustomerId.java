// package com.reservationSystem.domain.model.valueobject;

// public record CustomerId(Integer value) {
// public static CustomerId of(Integer value) {
// if (value == null || value <= 0) {
// throw new IllegalArgumentException("Invalid customer ID");
// }
// return new CustomerId(value);
// }
// }

package com.reservationSystem.domain.model.valueobject;

public record CustomerId(Integer value) {
    public CustomerId {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("Invalid customer ID");
        }
    }
}