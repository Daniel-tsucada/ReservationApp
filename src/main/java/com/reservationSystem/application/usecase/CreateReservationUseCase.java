package com.reservationSystem.application.usecase;

import com.reservationSystem.domain.model.entity.Reservation;
import com.reservationSystem.infrastructure.repository.ReservationRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateReservationUseCase {
    private final ReservationRepository reservationRepository;

    public CreateReservationUseCase(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Transactional
    public void execute(Reservation reservation) {
        reservationRepository.create(reservation);
    }
}