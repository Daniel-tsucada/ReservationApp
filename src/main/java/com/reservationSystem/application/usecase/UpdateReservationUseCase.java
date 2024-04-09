package com.reservationSystem.application.usecase;

import com.reservationSystem.domain.model.entity.Reservation;
import com.reservationSystem.domain.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateReservationUseCase {
    private final ReservationRepository reservationRepository;

    public UpdateReservationUseCase(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Transactional
    public void execute(Reservation reservation) {
        reservationRepository.update(reservation);
    }
}