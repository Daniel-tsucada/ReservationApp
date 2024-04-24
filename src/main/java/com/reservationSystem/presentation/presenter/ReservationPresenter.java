package com.reservationSystem.presentation.presenter;

import com.reservationSystem.application.reservation.ReservationOutput;
import com.reservationSystem.presentation.web.response.ReservationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservationPresenter {
    public ResponseEntity<List<ReservationResponse>> present(List<ReservationOutput> outputs) {
        List<ReservationResponse> responses = outputs.stream()
                .map(ReservationResponse::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }
}