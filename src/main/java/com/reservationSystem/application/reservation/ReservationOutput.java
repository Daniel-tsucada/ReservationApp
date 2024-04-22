package com.reservationSystem.application.reservation;

import com.reservationSystem.domain.model.valueobject.CustomerId;
import com.reservationSystem.domain.model.valueobject.ReservationId;
import com.reservationSystem.domain.model.valueobject.ServiceId;
import com.reservationSystem.domain.model.valueobject.Status;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ReservationOutput(
                ReservationId id,
                CustomerId customerId,
                ServiceId serviceId,
                LocalDateTime reservationDate,
                Status status) {
}