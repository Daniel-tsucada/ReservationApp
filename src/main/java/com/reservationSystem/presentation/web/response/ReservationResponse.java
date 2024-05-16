package com.reservationSystem.presentation.web.response;

import com.reservationSystem.application.reservation.ReservationOutput;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static ResponseEntity<List<ReservationResponse>> fromList(List<ReservationOutput> outputs) {
        List<ReservationResponse> responses = outputs.stream()
                .map(ReservationResponse::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }
}