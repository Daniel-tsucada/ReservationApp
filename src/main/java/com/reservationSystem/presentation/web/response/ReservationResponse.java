package com.reservationSystem.presentation.web.response;

import com.reservationSystem.application.reservation.ReservationOutput;
import java.time.LocalDateTime;

public record ReservationResponse(
        Integer id,
        Integer customerId,
        Integer serviceId,
        LocalDateTime reservationDate,
        String status) {

    public static ReservationResponse from(ReservationOutput output) {
        return new ReservationResponse(
                output.id().value(),
                output.customerId().value(),
                output.serviceId().value(),
                output.reservationDate(),
                output.status().name()
        );
    }
}