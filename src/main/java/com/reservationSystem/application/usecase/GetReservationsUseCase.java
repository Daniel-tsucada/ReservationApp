package com.reservationSystem.application.usecase;

import com.reservationSystem.domain.model.entity.Reservation;
import com.reservationSystem.infrastructure.repository.ReservationRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GetReservationsUseCase {
    private final ReservationRepository reservationRepository;

    public GetReservationsUseCase(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Transactional(readOnly = true)
    public List<Reservation> execute() {
        return reservationRepository.findAll();
    }
}