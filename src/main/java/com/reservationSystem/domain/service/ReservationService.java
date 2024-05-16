package com.reservationSystem.domain.service;

import com.reservationSystem.domain.model.entity.Reservation;
import com.reservationSystem.domain.model.valueobject.ReservationId;
import com.reservationSystem.infrastructure.repository.ReservationRepository;
import com.reservationSystem.application.reservation.ReservationOutput;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Transactional
    public void createReservation(Reservation reservation) {
        reservationRepository.createReservation(reservation);
    }

    @Transactional
    public void updateReservation(Reservation reservation) {
        reservationRepository.update(reservation);
    }

    @Transactional
    public void deleteReservation(ReservationId reservationId) {
        reservationRepository.delete(reservationId);
    }

    @Transactional(readOnly = true)
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }
}