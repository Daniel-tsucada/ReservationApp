package com.reservationSystem.application.usecase;

import com.reservationSystem.domain.model.aggregate.ReservationListAggregate;
import com.reservationSystem.domain.repository.ReservationListAggregateRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FetchReservationListUsecase {
    private final ReservationListAggregateRepository repository;

    public FetchReservationListUsecase(ReservationListAggregateRepository repository) {
        this.repository = repository;
    }

    public List<ReservationListAggregate> execute() {
        return repository.findAllReservationsWithDetails();
    }
}