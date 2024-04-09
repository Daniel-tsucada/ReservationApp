package com.reservationSystem.presentation.controller;

import com.reservationSystem.domain.service.*;
import com.reservationSystem.domain.model.entity.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.reservationSystem.domain.model.valueobject.ReservationId;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
        private final ReservationService reservationService;

        public ReservationController(ReservationService reservationService) {
                this.reservationService = reservationService;
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
        public ResponseEntity<List<Reservation>> getReservations() {
                List<Reservation> reservations = reservationService.getReservations();
                return new ResponseEntity<>(reservations, HttpStatus.OK);
        }
}