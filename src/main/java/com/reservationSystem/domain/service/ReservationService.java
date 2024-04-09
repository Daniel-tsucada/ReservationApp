package com.reservationSystem.domain.service;

import com.reservationSystem.domain.model.entity.Reservation;
import com.reservationSystem.domain.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.reservationSystem.domain.model.valueobject.ReservationId;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Transactional
    public void createReservation(Reservation reservation) {
        reservationRepository.create(reservation);
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