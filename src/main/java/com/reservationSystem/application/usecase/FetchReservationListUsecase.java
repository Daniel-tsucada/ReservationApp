package com.reservationSystem.application.usecase;

import com.reservationSystem.application.reservation.reservationAggregateOutput;
import com.reservationSystem.infrastructure.repository.ReservationListAggregateRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FetchReservationListUsecase {
    private final ReservationListAggregateRepository repository;

    public FetchReservationListUsecase(ReservationListAggregateRepository repository) {
        this.repository = repository;
    }

    public List<reservationAggregateOutput> execute() {
        return repository.findAllReservationsWithDetails().stream()
                .map(aggregate -> new reservationAggregateOutput(
                        aggregate.getId(),
                        aggregate.getCustomerId(),
                        aggregate.getStoreId(),
                        aggregate.getServiceId(),
                        aggregate.getCustomerName(),
                        aggregate.getEmail(),
                        aggregate.getPhone(),
                        aggregate.getStoreName(),
                        aggregate.getStoreAddress(),
                        aggregate.getServiceName(),
                        aggregate.getServiceDuration(),
                        aggregate.getServicePrice()))
                .collect(Collectors.toList());
    }
}
