package com.reservationSystem.application.usecase;

import com.reservationSystem.domain.model.valueobject.ReservationId;
import com.reservationSystem.domain.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteReservationUseCase {
    private final ReservationRepository reservationRepository;

    public DeleteReservationUseCase(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Transactional
    public void execute(ReservationId reservationId) {
        reservationRepository.delete(reservationId);
    }
}