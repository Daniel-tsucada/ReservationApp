package com.reservationSystem.infrastructure.repository;

import com.reservationSystem.domain.model.aggregate.ReservationListAggregate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReservationListAggregateRepository {
    List<ReservationListAggregate> findAllReservationsWithDetails();
}
