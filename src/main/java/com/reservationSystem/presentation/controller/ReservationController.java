package com.reservationSystem.presentation.controller;

import com.reservationSystem.domain.service.*;
import com.reservationSystem.domain.model.entity.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.reservationSystem.domain.model.valueobject.ReservationId;
import com.reservationSystem.application.reservation.ReservationOutput;
import com.reservationSystem.presentation.web.response.ReservationResponse;
import com.reservationSystem.presentation.presenter.ReservationPresenter;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;
    private final ReservationPresenter reservationPresenter;

    public ReservationController(ReservationService reservationService, ReservationPresenter reservationPresenter) {
        this.reservationService = reservationService;
        this.reservationPresenter = reservationPresenter;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createReservation(@RequestBody Reservation reservation) {
        reservationService.createReservation(reservation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateReservation(@RequestBody Reservation reservation) {
        reservationService.updateReservation(reservation);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Void> deleteReservation(@PathVariable ReservationId reservationId) {
        reservationService.deleteReservation(reservationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReservationResponse>> getReservations() {
        List<Reservation> reservations = reservationService.getReservations();
        return reservationPresenter.present(reservations);
    }
}