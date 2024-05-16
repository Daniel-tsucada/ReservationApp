package com.reservationSystem.presentation.presenter;

import com.reservationSystem.domain.model.entity.Reservation;
import com.reservationSystem.application.reservation.ReservationOutput;
import com.reservationSystem.presentation.web.response.ReservationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservationPresenter {
    public ResponseEntity<List<ReservationResponse>> present(List<Reservation> reservations) {
        List<ReservationResponse> responses = reservations.stream()
                .map(reservation -> ReservationOutput.builder()
                        .id(reservation.getId())
                        .customerId(reservation.getCustomerId())
                        .serviceId(reservation.getServiceId())
                        .reservationDate(reservation.getReservationDate())
                        .status(reservation.getStatus())
                        .build())
                .map(ReservationResponse::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }
}